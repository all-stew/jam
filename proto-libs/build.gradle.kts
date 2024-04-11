tasks.register("clean") {
    subprojects {
        dependsOn(":$name:clean")
    }
}

tasks.register("build") {
    subprojects {
        dependsOn(":$name:build")
    }
}
