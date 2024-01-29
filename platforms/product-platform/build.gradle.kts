plugins {
    id("java-platform")
}

group = "com.zhaojj11.jam.platform"

// allow the definition of dependencies to other platforms like the Spring Boot BOM
javaPlatform.allowDependencies()

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:3.0.0"))

    constraints {
        api("org.apache.juneau:juneau-marshall:8.2.0")
        api("com.google.code.findbugs:jsr305:3.0.2")
        api("org.apache.commons:commons-lang3:3.12.0")
        api("org.apache.groovy:groovy-all:4.0.15")
    }

}
