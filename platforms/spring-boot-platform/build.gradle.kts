plugins {
    id("java-platform")
}

group = "com.zhaojj11.jam.platform"

// allow the definition of dependencies to other platforms like the JUnit 5 BOM
javaPlatform.allowDependencies()

dependencies {
    api(platform(project(":plugins-platform")))
    api(platform(project(":product-platform")))

    api(enforcedPlatform("org.springframework.boot:spring-boot-dependencies:2.7.6"))
    api(enforcedPlatform("org.springframework.cloud:spring-cloud-dependencies:2021.0.5"))

    constraints {
        api("org.springframework.boot:org.springframework.boot.gradle.plugin:2.7.6")
    }
}