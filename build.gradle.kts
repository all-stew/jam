tasks.register("clean") {
    group = "build"
    description = "clean all"
    dependsOn(gradle.includedBuild("libs").task(":clean"))
    dependsOn(gradle.includedBuild("apps").task(":clean"))
}

tasks.register("build") {
    group = "build"
    description = "Build all"
    dependsOn(gradle.includedBuild("libs").task(":build"))
    dependsOn(gradle.includedBuild("apps").task(":build"))
}

tasks.register("checkstyle") {
    group = "build"
    description = "check style"
    dependsOn(gradle.includedBuild("libs").task(":checkstyle"))
    dependsOn(gradle.includedBuild("apps").task(":checkstyle"))
}


tasks.register("test") {
    group = "verification"
    description = "Run all tests"
    dependsOn(gradle.includedBuild("libs").task(":test"))
    dependsOn(gradle.includedBuild("apps").task(":test"))
}

tasks.register("sonar") {
    group = "verification"
    description = "send to sonar"
    dependsOn(gradle.includedBuild("libs").task(":sonar"))
    dependsOn(gradle.includedBuild("apps").task(":sonar"))
}


repositories {
    maven {
        setUrl("http://maven.aliyun.com/nexus/content/groups/public/")
    }
}
