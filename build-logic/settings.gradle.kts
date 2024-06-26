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
include("protobuf")
include("spring-boot-library")
include("spring-boot-application")
