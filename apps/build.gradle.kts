plugins {
    kotlin("jvm") version "1.9.23" apply false
}

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

tasks.register("checkstyle") {
    subprojects {
        dependsOn(":$name:checkstyleMain")
        dependsOn(":$name:checkstyleTest")
    }
}

tasks.register("test") {
    subprojects {
        dependsOn(":$name:test")
    }
}

tasks.register("sonar") {
    subprojects {
        dependsOn(":$name:sonar")
    }
}
