plugins {
    id("com.example.picsum.primitive.android.library")
    id("com.example.picsum.primitive.android.kotlin")
    id("com.example.picsum.primitive.android.kotlin.serialization")
    id("com.example.picsum.primitive.android.hilt")
    id("com.example.picsum.primitive.google.protobuf")
}

android.namespace = "com.example.picsum.model"
android.buildFeatures.resValues = false

dependencies {
    implementation(libs.androidx.room)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    implementation(libs.bundles.datastore)
}
