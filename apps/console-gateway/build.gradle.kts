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
        property("sonar.projectName", "jam")
    }
}

group = "${group}.apps"

repositories {
    mavenCentral()
}

dependencies {
    implementation(enforcedPlatform("org.springframework.boot:spring-boot-dependencies:3.0.0"))

    implementation("com.zhaojj11.jam.libs:core")
    implementation("com.zhaojj11.jam.libs:spring-core")
    implementation("com.zhaojj11.jam.libs:jpa-spring-boot-starter")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui")
    implementation("javax.xml.bind:jaxb-api:2.3.0")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")

    implementation("mysql:mysql-connector-java")

    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")
    implementation("io.jsonwebtoken:jjwt:0.9.0")

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

