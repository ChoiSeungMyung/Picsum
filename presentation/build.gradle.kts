import com.example.lookpin.primitive.implementation

plugins {
    id("com.example.lookpin.primitive.android.library")
    id("com.example.lookpin.primitive.android.kotlin")
    id("com.example.lookpin.primitive.android.hilt")
    id("com.example.lookpin.primitive.android.compose")
    id("com.example.lookpin.primitive.android.navigation")
}

android.namespace = "com.example.lookpin.presentation"
android.buildFeatures.dataBinding = true

dependencies {
    implementation(projects.core.base)
    implementation(projects.model)
    implementation(projects.domain)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.bundles.lifecycle)
    implementation(libs.androidx.fragment)
    implementation(libs.bundles.navigation)

    implementation(projects.core.navigation)

    implementation(projects.feature.photolist)
    implementation(projects.feature.photodetail)

    implementation(libs.timber)
}
