plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(platform("com.zhaojj11.jam.platform:spring-boot-platform"))

    implementation(project(":java-library"))

    implementation("org.springframework.boot:org.springframework.boot.gradle.plugin")
    implementation("io.freefair.lombok:io.freefair.lombok.gradle.plugin")
}