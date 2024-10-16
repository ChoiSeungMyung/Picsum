plugins {
    id("com.example.picsum.primitive.android.library")
    id("com.example.picsum.primitive.android.kotlin")
    id("com.example.picsum.primitive.android.hilt")
}

android.namespace = "com.example.picsum.data.local"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.model)

    implementation(libs.androidx.room)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    implementation(libs.bundles.datastore)
}
