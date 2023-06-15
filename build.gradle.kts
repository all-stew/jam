tasks.register("clean") {
    group = "build"
    description = "clean all apps"
    dependsOn(gradle.includedBuild("apps").task(":basket:clean"))
    dependsOn(gradle.includedBuild("apps").task(":albion-helper:clean"))
}

tasks.register("build") {
    group = "build"
    description = "Build all apps"
    dependsOn(gradle.includedBuild("apps").task(":basket:build"))
    dependsOn(gradle.includedBuild("apps").task(":albion-helper:build"))
}


// This is an example of a lifecycle task that crosses build boundaries defined in the umbrella build.
tasks.register("test") {
    group = "verification"
    description = "Run all tests"
    dependsOn(gradle.includedBuild("libs").task(":core:test"))
    dependsOn(gradle.includedBuild("apps").task(":basket:test"))
    dependsOn(gradle.includedBuild("apps").task(":albion-helper:test"))
}

tasks.register("sonar") {
    group = "verification"
    description = "send to sonar"
    dependsOn(gradle.includedBuild("libs").task(":core:test"))
    dependsOn(gradle.includedBuild("apps").task(":basket:sonar"))
    dependsOn(gradle.includedBuild("apps").task(":albion-helper:sonar"))
}
