package com.example.lookpin.primitive

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidKotlinSymbolPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("kotlin-ksp").pluginId)
            }

            dependencies {
                implementation(libs.library("kotlinx-ksp"))
            }
        }
    }
}
