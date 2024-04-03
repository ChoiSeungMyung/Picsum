pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "lookpin"
include(":app")
include(":core:base")
include(":core:ui")
include(":core:navigation")
include(":model")
include(":data")
include(":data:local")
include(":data:remote")
include(":domain")
include(":presentation")
include(":feature:photolist")
include(":feature:photodetail")
