plugins {
    id("java-platform")
}

group = "com.zhaojj11.jam.platform"

dependencies {
    constraints {
        api("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:1.7.21")
        api("org.jetbrains.kotlin.plugin.allopen:org.jetbrains.kotlin.allopen.gradle.plugin:1.7.21")
        api("org.springframework.boot:org.springframework.boot.gradle.plugin:3.0.0")
        api("io.freefair.lombok:io.freefair.lombok.gradle.plugin:6.5.1")
    }
}
