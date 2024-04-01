package com.example.lookpin.primitive

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KotlinUnitTestPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            android {
                testOptions {
                    unitTests.isIncludeAndroidResources = true
                    unitTests.all { test -> test.useJUnitPlatform() }
                }
            }

            dependencies {
                testImplementation(libs.library("junit"))
                testImplementation(libs.library("androidx-test-core"))
                testImplementation(libs.library("kotlin-test-junit"))
                testImplementation(libs.library("kotlin-reflection"))
                // Truth
                testImplementation(libs.library("truth"))
                testImplementation(libs.library("truth-ext"))
                // Coroutines Test
                testImplementation(libs.library("kotlinx-coroutines-test"))
                testImplementation(libs.library("turbine"))
                // Kotest
                testImplementation(libs.library("kotest-runner"))
                testImplementation(libs.library("kotest-property"))
                // Mock
                testImplementation(libs.library("mockk"))
                testImplementation(libs.library("mockk-android"))
                testImplementation(libs.library("mockk-agent"))
                // Mock
                testImplementation(libs.library("mockito"))
                testImplementation(libs.library("mockito-kotlin"))
            }
        }
    }
}
