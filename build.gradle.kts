tasks.register("clean") {
    group = "build"
    description = "clean all apps"
    dependsOn(gradle.includedBuild("apps").task(":sample:clean"))
}

tasks.register("build") {
    group = "build"
    description = "Build all apps"
    dependsOn(gradle.includedBuild("apps").task(":sample:build"))
}


// This is an example of a lifecycle task that crosses build boundaries defined in the umbrella build.
tasks.register("test") {
    group = "verification"
    description = "Run all apps tests"
    dependsOn(gradle.includedBuild("apps").task(":sample:test"))
}

tasks.register("sonar") {
    group = "verification"
    description = "send to sonar"
    dependsOn(gradle.includedBuild("apps").task(":sample:sonar"))
}
