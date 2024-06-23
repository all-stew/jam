dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}

rootProject.name = "libs"

include("core")
include("grpc-test")
include("jpa-core")
include("spring-core")
