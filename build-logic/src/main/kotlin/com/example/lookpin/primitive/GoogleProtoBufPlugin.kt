package com.example.lookpin.primitive

import org.gradle.api.Plugin
import org.gradle.api.Project

class GoogleProtoBufPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.protobuf")
            }

            setupProtobuf()
        }
    }
}
