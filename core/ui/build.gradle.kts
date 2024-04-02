plugins {
    id("com.example.lookpin.primitive.android.library")
    id("com.example.lookpin.primitive.android.kotlin")
    id("com.example.lookpin.primitive.android.kotlin.ksp")

}

android.namespace = "com.example.lookpin.core.ui"
android.buildFeatures.dataBinding = true

dependencies {
    implementation(libs.androidx.constraintlayout)

    implementation(libs.bundles.glide)
    ksp(libs.glide.compiler)
}
