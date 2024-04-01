plugins {
    id("com.example.lookpin.primitive.android.library")
    id("com.example.lookpin.primitive.android.kotlin")
    id("com.example.lookpin.primitive.android.kotlin.serialization")
    id("com.example.lookpin.primitive.android.hilt")
}

android.namespace = "com.example.lookpin.data.remote"
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
