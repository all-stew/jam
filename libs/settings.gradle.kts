dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}

rootProject.name = "libs"

include("core")
include("spring-core")
include("spring-jpa-core")