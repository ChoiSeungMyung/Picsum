plugins {
    id("com.example.picsum.primitive.android.library")
    id("com.example.picsum.primitive.android.kotlin")
    id("com.example.picsum.primitive.android.kotlin.serialization")
    id("com.example.picsum.primitive.android.hilt")
}

android.namespace = "com.example.picsum.data.remote"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.model)

    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.serialization)

    implementation(libs.timber)
}
