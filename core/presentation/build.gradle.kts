plugins {
    id("com.example.lookpin.primitive.android.library")
    id("com.example.lookpin.primitive.android.kotlin")
}

android.namespace = "com.example.lookpin.core.presentation"
android.buildFeatures.resValues = false

dependencies {
    implementation(libs.bundles.lifecycle)
    implementation(libs.timber)
    implementation(libs.androidx.core)
}
