package com.mgarciaguerr.avocado.plugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.ui.Messages
import com.mgarciaguerr.avocado.plugin.extension.empty
import java.io.IOException

open class OptimizationBaseAction : AnAction() {

    companion object {

        private const val REGEX_TERMINAL_COLOR = "\u001B\\[[;\\d]*m"
    }

    override fun actionPerformed(anActionEvent: AnActionEvent) {
        anActionEvent.getData(PlatformDataKeys.VIRTUAL_FILE)?.canonicalPath?.let {
            try {
                val proc = ProcessBuilder("avocado", it).start()
                proc.waitFor()
                handleSuccess(anActionEvent, proc)
            } catch (e: Exception) {
                handleError(anActionEvent, e)
            }
        }
    }

    private fun handleError(anActionEvent: AnActionEvent, e: Exception) {
        val text = when (e) {
            is IOException -> AVOCADO_NOT_INSTALLED_ERROR
            else -> GENERIC_ERROR
        }
        Messages.showMessageDialog(anActionEvent.project, text, TITLE_MESSAGE_ERROR, null)
    }

    private fun handleSuccess(anActionEvent: AnActionEvent, proc: Process) {
        val errorMessage = proc.errorStream?.bufferedReader()?.readText().orEmpty().replace(Regex(REGEX_TERMINAL_COLOR), String.empty())
        val successMessage = proc.inputStream?.bufferedReader()?.readText().orEmpty().replace(Regex(REGEX_TERMINAL_COLOR), String.empty())
        when {
            errorMessage.isNotBlank() -> {
                Messages.showMessageDialog(anActionEvent.project, errorMessage, TITLE_MESSAGE_ERROR, null)
            }
            successMessage.isNotBlank() -> {
                Messages.showMessageDialog(anActionEvent.project, successMessage, TITLE_MESSAGE_SUCCESS, null)
            }
            else -> {
                Messages.showMessageDialog(anActionEvent.project, GENERIC_ERROR, TITLE_MESSAGE_ERROR, null)
            }
        }
    }
}