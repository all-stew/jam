plugins {
    id("java-platform")
}

group = "com.zhaojj11.jam.platform"

// allow the definition of dependencies to other platforms like the Spring Boot BOM
javaPlatform.allowDependencies()

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:2.7.6"))

    constraints {
        api("org.apache.juneau:juneau-marshall:8.2.0")
        api("com.google.code.findbugs:jsr305:3.0.2")
    }
}
