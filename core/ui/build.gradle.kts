plugins {
    id("com.example.picsum.primitive.android.library")
    id("com.example.picsum.primitive.android.kotlin")
    id("com.example.picsum.primitive.android.kotlin.ksp")
}

android.namespace = "com.example.picsum.core.ui"
android.buildFeatures.dataBinding = true

dependencies {
    implementation(libs.androidx.constraintlayout)

    implementation(libs.bundles.glide)
    ksp(libs.glide.compiler)
}
