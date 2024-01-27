dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}

rootProject.name = "libs"

include("core")
include("spring-core")
include("test-spring-boot-starter")
include("jpa-spring-boot-starter")
