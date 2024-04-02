plugins {
    id("com.example.lookpin.primitive.android.library")
    id("com.example.lookpin.primitive.android.kotlin")
    id("com.example.lookpin.primitive.android.hilt")
}

android.namespace = "com.example.lookpin.domain"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.model)
    implementation(projects.data)
}