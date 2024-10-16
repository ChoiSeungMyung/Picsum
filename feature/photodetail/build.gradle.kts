import com.example.picsum.primitive.implementation

plugins {
    id("com.example.picsum.primitive.android.library")
    id("com.example.picsum.primitive.android.kotlin")
    id("com.example.picsum.primitive.android.hilt")
    id("com.example.picsum.primitive.android.navigation")
    id("com.example.picsum.primitive.android.compose")
}

android.namespace = "com.example.picsum.feature.photodetail"
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
