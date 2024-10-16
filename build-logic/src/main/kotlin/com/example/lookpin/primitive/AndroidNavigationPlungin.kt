package com.example.picsum.primitive

import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidNavigationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("navigation-safe-args").pluginId)
            }
        }
    }
}
