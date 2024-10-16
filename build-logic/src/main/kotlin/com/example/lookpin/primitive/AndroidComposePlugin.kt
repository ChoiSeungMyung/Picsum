package com.example.picsum.primitive

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            android {
                buildFeatures.compose = true
                composeOptions {
                    kotlinCompilerExtensionVersion = libs.version("androidx_compose_compiler")
                }
            }

            dependencies {
                implementation(libs.bundle("compose"))
                implementation(libs.bundle("compose-animation"))
                implementation(libs.bundle("compose-basic"))
                implementation(libs.bundle("compose-ui"))
                implementation(libs.bundle("compose-navigation"))
                implementation(libs.bundle("compose-lifecycle"))
            }
        }
    }
}
