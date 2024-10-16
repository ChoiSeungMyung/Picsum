import com.example.picsum.primitive.implementation

plugins {
    id("com.example.picsum.primitive.android.library")
    id("com.example.picsum.primitive.android.kotlin")
    id("com.example.picsum.primitive.android.hilt")
}

android.namespace = "com.example.picsum.data"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.model)
    implementation(projects.data.local)
    implementation(projects.data.remote)
    implementation(libs.kotlinx.collections.immutable)
}
