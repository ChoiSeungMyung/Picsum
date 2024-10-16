import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.example.picsum.buildlogic"

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
    implementation(libs.androidx.navigation.safe.args.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.example.picsum.primitive.android.application"
            implementationClass = "com.example.picsum.primitive.AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "com.example.picsum.primitive.android.library"
            implementationClass = "com.example.picsum.primitive.AndroidLibraryPlugin"
        }
        register("androidProguard") {
            id = "com.example.picsum.primitive.android.proguard"
            implementationClass = "com.example.picsum.primitive.AndroidProguardPlugin"
        }
        register("androidUnitTest") {
            id = "com.example.picsum.primitive.android.unitTest"
            implementationClass = "com.example.picsum.primitive.KotlinUnitTestPlugin"
        }
        register("androidCompose") {
            id = "com.example.picsum.primitive.android.compose"
            implementationClass = "com.example.picsum.primitive.AndroidComposePlugin"
        }
        register("androidHilt") {
            id = "com.example.picsum.primitive.android.hilt"
            implementationClass = "com.example.picsum.primitive.AndroidHiltPlugin"
        }
        register("androidKotlinPlugin") {
            id = "com.example.picsum.primitive.android.kotlin"
            implementationClass = "com.example.picsum.primitive.AndroidKotlinPlugin"
        }
        register("androidKotlinSerializationPlugin") {
            id = "com.example.picsum.primitive.android.kotlin.serialization"
            implementationClass = "com.example.picsum.primitive.AndroidKotlinSerializationPlugin"
        }
        register("androidKotlinParcelizePlugin") {
            id = "com.example.picsum.primitive.android.kotlin.parcelize"
            implementationClass = "com.example.picsum.primitive.AndroidKotlinParcelizePlugin"
        }
        register("androidKotlinSymbolPlugin") {
            id = "com.example.picsum.primitive.android.kotlin.ksp"
            implementationClass = "com.example.picsum.primitive.AndroidKotlinSymbolPlugin"
        }

        // Navigation
        register("androidNavigation") {
            id = "com.example.picsum.primitive.android.navigation"
            implementationClass = "com.example.picsum.primitive.AndroidNavigationPlugin"
        }

        // Conventions
        register("androidFeature") {
            id = "com.example.picsum.convention.feature"
            implementationClass = "com.example.picsum.convention.AndroidFeaturePlugin"
        }

        register("GoogleProtoBuf") {
            id = "com.example.picsum.primitive.google.protobuf"
            implementationClass = "com.example.picsum.primitive.GoogleProtoBufPlugin"
        }
    }
}
