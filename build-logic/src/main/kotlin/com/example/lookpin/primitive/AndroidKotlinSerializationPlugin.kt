package com.example.picsum.primitive

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidKotlinSerializationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("kotlin-serialization").pluginId)
            }

            dependencies {
                implementation(libs.library("kotlinx-serialization-json"))
            }
        }
    }
}
