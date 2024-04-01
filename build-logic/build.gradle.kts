import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.example.lookpin.buildlogic"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.android.gradlePlugin)
    implementation(libs.hilt.android.gradlePlugin)
    implementation(libs.protobuf.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.example.lookpin.primitive.android.application"
            implementationClass = "com.example.lookpin.primitive.AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "com.example.lookpin.primitive.android.library"
            implementationClass = "com.example.lookpin.primitive.AndroidLibraryPlugin"
        }
        register("androidProguard") {
            id = "com.example.lookpin.primitive.android.proguard"
            implementationClass = "com.example.lookpin.primitive.AndroidProguardPlugin"
        }
        register("androidUnitTest") {
            id = "com.example.lookpin.primitive.android.unitTest"
            implementationClass = "com.example.lookpin.primitive.KotlinUnitTestPlugin"
        }
        register("androidCompose") {
            id = "com.example.lookpin.primitive.android.compose"
            implementationClass = "com.example.lookpin.primitive.AndroidComposePlugin"
        }
        register("androidHilt") {
            id = "com.example.lookpin.primitive.android.hilt"
            implementationClass = "com.example.lookpin.primitive.AndroidHiltPlugin"
        }
        register("androidKotlinPlugin") {
            id = "com.example.lookpin.primitive.android.kotlin"
            implementationClass = "com.example.lookpin.primitive.AndroidKotlinPlugin"
        }
        register("androidKotlinSerializationPlugin") {
            id = "com.example.lookpin.primitive.android.kotlin.serialization"
            implementationClass = "com.example.lookpin.primitive.AndroidKotlinSerializationPlugin"
        }
        register("androidKotlinParcelizePlugin") {
            id = "com.example.lookpin.primitive.android.kotlin.parcelize"
            implementationClass = "com.example.lookpin.primitive.AndroidKotlinParcelizePlugin"
        }
        register("androidKotlinSymbolPlugin") {
            id = "com.example.lookpin.primitive.android.kotlin.ksp"
            implementationClass = "com.example.lookpin.primitive.AndroidKotlinSymbolPlugin"
        }

        // Conventions
        register("androidFeature") {
            id = "com.example.lookpin.convention.feature"
            implementationClass = "com.example.lookpin.convention.AndroidFeaturePlugin"
        }

        register("GoogleProtoBuf") {
            id = "com.example.lookpin.primitive.google.protobuf"
            implementationClass = "com.example.lookpin.primitive.GoogleProtoBufPlugin"
        }
    }
}
