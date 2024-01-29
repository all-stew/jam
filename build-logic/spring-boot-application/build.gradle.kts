plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(platform("com.zhaojj11.jam.platform:spring-boot-platform"))
    implementation(platform("com.zhaojj11.jam.platform:test-platform"))

    implementation(project(":commons"))

    implementation("org.springframework.boot:org.springframework.boot.gradle.plugin")
    implementation("io.freefair.lombok:io.freefair.lombok.gradle.plugin")
}
