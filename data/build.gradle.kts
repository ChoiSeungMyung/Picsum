import com.example.lookpin.primitive.implementation

plugins {
    id("com.example.lookpin.primitive.android.library")
    id("com.example.lookpin.primitive.android.kotlin")
    id("com.example.lookpin.primitive.android.hilt")
}

android.namespace = "com.example.lookpin.data"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.model)
    implementation(projects.data.local)
    implementation(projects.data.remote)
    implementation(libs.kotlinx.collections.immutable)
}
