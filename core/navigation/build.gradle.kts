plugins {
    id("com.example.picsum.primitive.android.library")
    id("com.example.picsum.primitive.android.kotlin")
}

android.namespace = "com.example.picsum.core.navigation"

dependencies {
    implementation(libs.bundles.navigation)
}
