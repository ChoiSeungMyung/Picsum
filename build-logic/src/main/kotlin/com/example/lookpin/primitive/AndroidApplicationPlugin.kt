package com.example.lookpin.primitive

import com.example.lookpin.internal.Dimension
import com.example.lookpin.internal.Flavors
import com.example.lookpin.internal.Version
import com.example.lookpin.internal.debug
import com.example.lookpin.internal.proguardPath
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply(libs.plugin("protobuf").pluginId)
                apply(libs.plugin("hilt").pluginId)
            }

            androidApplication {
                setupAndroid()

                defaultConfig {
                    applicationId = "com.example.lookpin"
                    versionCode = Version.version_code
                    versionName = Version.version_name
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    vectorDrawables.useSupportLibrary = true
                }

                bundle {
                    language {
                        enableSplit = false
                    }
                }

                signingConfigs {
                    debug {
                        storeFile = file("$rootDir/settings/debug.keystore")
                    }
                }

                buildTypes {
                    debug
                    release {
                        isMinifyEnabled = true
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
                        proguardPath("$rootDir/app/proguard")
                    }
                }

                flavorDimensions.add(Dimension.VERSION)
                productFlavors {
                    create(Flavors.DEV) { proguardFile("debug/proguard-debug.pro") }
                    create(Flavors.STAGING)
                    create(Flavors.PRODUCTION)

                    forEach { flavor ->
                        with(flavor) {
                            dimension = Dimension.VERSION

                            if (name != Flavors.PRODUCTION) {
                                applicationIdSuffix = name
                            } else {
                                versionName = Version.production_version_name
                            }
                        }
                    }
                }

                lint {
                    checkReleaseBuilds = false
                    abortOnError = false
                }
            }
        }
    }
}