plugins {
    id("java-platform")
    id("checkstyle")
}

checkstyle {
    toolVersion = "10.12.5"
}

group = "com.zhaojj11.jam.platform"

dependencies {
    constraints {
        api("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:1.9.23")
        api("org.jetbrains.kotlin.plugin.allopen:org.jetbrains.kotlin.allopen.gradle.plugin:1.9.23")
        api("gradle.plugin.com.github.johnrengelman:shadow:7.1.2")
        api("io.freefair.lombok:io.freefair.lombok.gradle.plugin:8.6")
    }
}
