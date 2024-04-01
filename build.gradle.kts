import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.kotlin.ksp) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.gms) apply false
    alias(libs.plugins.protobuf) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
    alias(libs.plugins.firebase.perf) apply false
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.ktlint.idea)
    alias(libs.plugins.modulegraph)
}

private val ANDROID_BASE_PLUGIN_ID = "com.android.base"
private val ANDROID_PLUGIN_IDS = listOf(
    "android",
    "android-library",
    "com.android.feature",
    "com.android.instantapp",
    "com.android.library",
    "com.android.test",
)
val Project.isAndroidProject: Boolean
    get() = plugins.hasPlugin(ANDROID_BASE_PLUGIN_ID) ||
        ANDROID_PLUGIN_IDS.any { pluginId -> plugins.hasPlugin(pluginId) }

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    configure<KtlintExtension> {
        version.set("0.48.2")
        outputColorName.set("RED")
        if (isAndroidProject) {
            android.set(true)
        }
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_17.toString()
                freeCompilerArgs = listOf(
                    "-opt-in=kotlin.RequiresOptIn",
                    "-Xcontext-receivers",
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=${projectDir.absolutePath}/compose-metrics",
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=${projectDir.absolutePath}/compose-reports",
                )
            }
        }
    }
}

moduleGraphConfig {
    readmePath.set("$projectDir/README.md")
    heading.set("### Dependency Diagram")
}
