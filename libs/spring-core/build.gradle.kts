plugins {
    id("com.zhaojj11.jam.spring-boot-library")
    id("io.freefair.lombok") version "6.5.1"
    id("org.sonarqube") version "3.5.0.2730"
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
    implementation(project(":core"))

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.google.code.findbugs:jsr305")
    implementation("org.apache.groovy:groovy-all")
    implementation("org.apache.commons:commons-lang3")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
