plugins {
    id("com.example.lookpin.primitive.android.library")
    id("com.example.lookpin.primitive.android.kotlin")
}

android.namespace = "com.example.lookpin.core.domain"

dependencies {
    implementation(libs.timber)
}
