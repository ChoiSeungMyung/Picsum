import com.example.lookpin.primitive.implementation

plugins {
    id("com.example.lookpin.primitive.android.library")
    id("com.example.lookpin.primitive.android.kotlin")
    id("com.example.lookpin.primitive.android.hilt")
    id("com.example.lookpin.primitive.android.navigation")
    id("com.example.lookpin.primitive.android.compose")
}

android.namespace = "com.example.lookpin.feature.photodetail"
android.buildFeatures.compose = true

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.fragment)

    implementation(libs.bundles.compose.lifecycle)
    implementation(libs.bundles.navigation)
    implementation(libs.bundles.coil)

    implementation(projects.model)
    implementation(projects.domain)
    implementation(projects.core.base)
}
