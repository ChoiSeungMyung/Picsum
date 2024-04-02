plugins {
    id("com.example.lookpin.primitive.android.library")
    id("com.example.lookpin.primitive.android.kotlin")
}

android.namespace = "com.example.lookpin.core.base"
android.buildFeatures.resValues = false
android.buildFeatures.dataBinding = true

dependencies {
    implementation(libs.bundles.lifecycle)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.recyclerview)

    implementation(libs.timber)
}