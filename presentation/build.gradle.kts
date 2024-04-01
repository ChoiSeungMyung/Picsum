plugins {
    id("com.example.lookpin.primitive.android.library")
    id("com.example.lookpin.primitive.android.kotlin")
    id("com.example.lookpin.primitive.android.hilt")
    id("com.example.lookpin.primitive.android.compose")
}

android.namespace = "com.example.lookpin.presentation"
android.buildFeatures.compose = true

dependencies {
    implementation(projects.model)
    implementation(projects.domain)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.coil)
}
