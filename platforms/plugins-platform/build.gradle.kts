plugins {
    id("java-platform")
}

group = "com.zhaojj11.jam.platform"

dependencies {
    constraints {
        api("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:1.7.21")
        api("org.jetbrains.kotlin.plugin.allopen:org.jetbrains.kotlin.allopen.gradle.plugin:1.7.21")
        api("gradle.plugin.com.github.johnrengelman:shadow:7.1.2")
        api("io.freefair.lombok:io.freefair.lombok.gradle.plugin:6.5.1")
    }
}
