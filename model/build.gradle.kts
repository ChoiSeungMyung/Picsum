plugins {
    id("com.example.lookpin.primitive.android.library")
    id("com.example.lookpin.primitive.android.kotlin")
    id("com.example.lookpin.primitive.android.kotlin.serialization")
    id("com.example.lookpin.primitive.android.hilt")
    id("com.example.lookpin.primitive.google.protobuf")
}

android.namespace = "com.example.lookpin.model"
android.buildFeatures.resValues = false

dependencies {
    implementation(libs.androidx.room)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    implementation(libs.bundles.datastore)
}
