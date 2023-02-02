plugins {
    id("jacoco")
    id("com.zhaojj11.jam.spring-boot-application")
    id("org.sonarqube") version ("3.5.0.2730")
}

sonarqube {
    properties {
        property("sonar.projectKey", "all-stew_jam")
        property("sonar.organization", "all-stew")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.projectName", "jam")
    }
}

group = "${group}.apps"

repositories {
    mavenCentral()
}

dependencies {
    implementation(enforcedPlatform("org.springframework.boot:spring-boot-dependencies:2.7.6"))
    implementation(enforcedPlatform("org.springframework.cloud:spring-cloud-dependencies:2021.0.5"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
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

