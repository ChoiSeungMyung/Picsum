import com.example.picsum.primitive.implementation

plugins {
    id("com.example.picsum.primitive.android.library")
    id("com.example.picsum.primitive.android.kotlin")
    id("com.example.picsum.primitive.android.hilt")
    id("com.example.picsum.primitive.android.compose")
    id("com.example.picsum.primitive.android.navigation")
}

android.namespace = "com.example.picsum.presentation"
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
