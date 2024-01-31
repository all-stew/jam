tasks.register("clean") {
    group = "build"
    description = "clean all apps"
    dependsOn(gradle.includedBuild("apps").task(":console-gateway:clean"))
}

tasks.register("build") {
    group = "build"
    description = "Build all apps"
    dependsOn(gradle.includedBuild("apps").task(":console-gateway:build"))
}


// This is an example of a lifecycle task that crosses build boundaries defined in the umbrella build.
tasks.register("test") {
    group = "verification"
    description = "Run all tests"
    dependsOn(gradle.includedBuild("libs").task(":core:test"))
    dependsOn(gradle.includedBuild("apps").task(":console-gateway:test"))
}

tasks.register("sonar") {
    group = "verification"
    description = "send to sonar"
    dependsOn(gradle.includedBuild("libs").task(":core:test"))
    dependsOn(gradle.includedBuild("apps").task(":console-gateway:sonar"))
}


repositories {
    maven {
        setUrl("http://maven.aliyun.com/nexus/content/groups/public/")
    }
}
