package com.example.picsum.primitive

import com.example.picsum.internal.proguardPath
import com.example.picsum.internal.release
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidProguardPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            android {
                buildTypes {
                    release {
                        isMinifyEnabled = true
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
                        proguardPath("$projectDir/proguard")
                    }
                }
            }
        }
    }
}
