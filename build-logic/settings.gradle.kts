dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}
includeBuild("../platforms")

rootProject.name = "build-logic"
include("commons")
include("java-library")
include("kotlin-library")
include("report-aggregation")
include("spring-boot-application")
