package com.mgarciaguerr.avocado.plugin

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys

class OptimizationDrawableVectorAction : OptimizationBaseAction() {

    companion object {

        private const val DRAWABLE_FOLDER = "drawable"
    }

    override fun update(anActionEvent: AnActionEvent) {
        val canBeEnabledAndVisible = anActionEvent.project
                ?.let { anActionEvent.getData(PlatformDataKeys.VIRTUAL_FILE) }
                ?.let { it.name == DRAWABLE_FOLDER && it.isDirectory} ?: false
        anActionEvent.presentation.isEnabledAndVisible = canBeEnabledAndVisible
    }
}
