plugins {
    id("com.example.picsum.primitive.android.library")
    id("com.example.picsum.primitive.android.kotlin")
    id("com.example.picsum.primitive.android.hilt")
}

android.namespace = "com.example.picsum.domain"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.model)
    implementation(projects.data)
}
