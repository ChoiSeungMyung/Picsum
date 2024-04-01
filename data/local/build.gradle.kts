plugins {
    id("com.example.lookpin.primitive.android.library")
    id("com.example.lookpin.primitive.android.kotlin")
    id("com.example.lookpin.primitive.android.hilt")
}

android.namespace = "com.example.lookpin.data.local"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.model)

    implementation(libs.androidx.room)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    implementation(libs.bundles.datastore)
}
