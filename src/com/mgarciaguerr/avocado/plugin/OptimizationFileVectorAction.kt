package com.mgarciaguerr.avocado.plugin

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys

class OptimizationFileVectorAction : OptimizationBaseAction() {

    companion object {

        private const val XML_EXTENSION = "xml"
        private const val DRAWABLE_FOLDER = "drawable"
    }

    override fun update(anActionEvent: AnActionEvent) {
        val canBeEnabledAndVisible = anActionEvent.project
                ?.let { anActionEvent.getData(PlatformDataKeys.VIRTUAL_FILE) }
                ?.let { it.extension == XML_EXTENSION && it.parent.name == DRAWABLE_FOLDER } ?: false
        anActionEvent.presentation.isEnabledAndVisible = canBeEnabledAndVisible
    }
}
