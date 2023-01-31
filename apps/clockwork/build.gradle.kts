plugins {
    id("jacoco")
    id("io.freefair.lombok") version "6.5.1"
    id("com.zhaojj11.jam.spring-boot-application")
    id("org.sonarqube") version ("3.5.0.2730")
}

sonarqube {
    properties {
        property("sonar.projectKey", "all-stew_jam")
        property("sonar.organization", "all-stew")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

group = "${group}.apps"

repositories {
    mavenCentral()
}

dependencies {
    implementation(enforcedPlatform("org.springframework.boot:spring-boot-dependencies:2.7.6"))
    implementation(enforcedPlatform("org.springframework.cloud:spring-cloud-dependencies:2021.0.5"))

    // 一方
    implementation("com.zhaojj11.jam.libs:core")

    // 二方

    // 三方
    // java
    implementation("javax.xml.bind:jaxb-api:2.3.0")
    // spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    // data
    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.2")
    implementation("mysql:mysql-connector-java:5.1.49")

    // jwt
    implementation("io.jsonwebtoken:jjwt:0.9.0")

    // mapstruct
    implementation("org.mapstruct:mapstruct:1.4.1.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.4.1.Final")
    testAnnotationProcessor("org.mapstruct:mapstruct-processor:1.4.1.Final")

    // apache common
    implementation("org.apache.commons:commons-lang3")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("io.codearte.jfairy:jfairy:0.5.9")
}

tasks.jacocoTestReport {
    enabled = true
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.required.set(true)
    }
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}

