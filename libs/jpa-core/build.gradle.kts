plugins {
    id("com.zhaojj11.jam.spring-boot-library")
    id("io.freefair.lombok") version "8.6"
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

group = "${group}.libs"


dependencies {
    implementation("com.zhaojj11.jam.protobuf:common")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.google.code.findbugs:jsr305")
    implementation("com.google.protobuf:protobuf-java")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
