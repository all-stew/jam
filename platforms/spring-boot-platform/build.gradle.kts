plugins {
    id("java-platform")
}

group = "com.zhaojj11.jam.platform"

// allow the definition of dependencies to other platforms like the JUnit 5 BOM
javaPlatform.allowDependencies()

dependencies {
    api(platform(project(":plugins-platform")))
    api(platform(project(":product-platform")))

    api(enforcedPlatform("org.springframework.boot:spring-boot-dependencies:3.2.4"))

    constraints {
        api("org.springframework.boot:org.springframework.boot.gradle.plugin:3.2.4")
        api("com.google.code.findbugs:jsr305:3.0.2")
    }
}
