@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.example.lookpin.primitive.android.application")
    id("com.example.lookpin.primitive.android.kotlin")
    id("com.example.lookpin.primitive.android.kotlin.serialization")
    id("com.example.lookpin.primitive.android.kotlin.parcelize")
    id("com.example.lookpin.primitive.android.hilt")
    id("com.example.lookpin.primitive.android.compose")
    id("com.example.lookpin.primitive.android.unitTest")
    alias(libs.plugins.firebase.crashlytics)
}

android {
    namespace = "com.example.lookpin"

    buildFeatures {
        this.dataBinding = true
        this.viewBinding = true
        this.buildConfig = true
    }
}

dependencies {
    implementation(projects.model)
    implementation(projects.data)
    implementation(projects.data.remote)
    implementation(projects.domain)
    implementation(projects.presentation)

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)

    implementation(libs.timber)
}
