dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}

rootProject.name = "libs"

include("core")
include("jpa-spring-boot-starter")
include("spring-core")
