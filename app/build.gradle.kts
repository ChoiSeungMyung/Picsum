@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.example.picsum.primitive.android.application")
    id("com.example.picsum.primitive.android.kotlin")
    id("com.example.picsum.primitive.android.kotlin.serialization")
    id("com.example.picsum.primitive.android.kotlin.parcelize")
    id("com.example.picsum.primitive.android.hilt")
    id("com.example.picsum.primitive.android.compose")
    id("com.example.picsum.primitive.android.unitTest")
}

android {
    namespace = "com.example.picsum"

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
