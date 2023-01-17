plugins {
    id("org.sonarqube") version ("3.5.0.2730")
}

sonarqube {
    properties {
        property("sonar.projectKey", "all-stew_jam")
        property("sonar.organization", "all-stew")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

tasks.register("clean-all-apps") {
    group = "build"
    description = "clean all apps"
    dependsOn(gradle.includedBuild("apps").task(":sample:clean"))
}

tasks.register("build-all-apps") {
    group = "build"
    description = "Build all apps"
    dependsOn(gradle.includedBuild("apps").task(":sample:build"))
}


// This is an example of a lifecycle task that crosses build boundaries defined in the umbrella build.
tasks.register("test-all-apps") {
    group = "verification"
    description = "Run all apps tests"
    dependsOn(gradle.includedBuild("apps").task(":sample:test"))
}
