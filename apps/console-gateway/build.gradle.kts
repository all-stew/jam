plugins {
    id("jacoco")
    id("io.freefair.lombok") version "8.6"
    id("com.zhaojj11.jam.spring-boot-application")
    id("org.sonarqube") version "4.0.0.2929"
    id("checkstyle")
}

checkstyle {
    toolVersion = "10.12.5"
    configFile = file("../../config/checkstyle/checkstyle.xml")
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

    implementation("com.zhaojj11.jam.libs:core")
    implementation("com.zhaojj11.jam.libs:spring-core")

    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui")
    implementation("javax.xml.bind:jaxb-api:2.3.0")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")

    runtimeOnly("mysql:mysql-connector-java")

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


