import com.example.lookpin.primitive.implementation

plugins {
    id("com.example.lookpin.primitive.android.library")
    id("com.example.lookpin.primitive.android.kotlin")
    id("com.example.lookpin.primitive.android.hilt")
    id("com.example.lookpin.primitive.android.kotlin.ksp")
    id("com.example.lookpin.primitive.android.navigation")
}

android.namespace = "com.example.lookpin.feature.photolist"
android.buildFeatures.dataBinding = true

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.fragment)

    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.navigation)

    implementation(libs.bundles.glide)
    ksp(libs.glide.compiler)

    implementation(projects.model)
    implementation(projects.domain)
    implementation(projects.core.base)
    implementation(projects.core.ui)
    implementation(projects.core.navigation)
}
