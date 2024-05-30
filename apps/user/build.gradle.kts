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
    implementation("com.zhaojj11.jam.libs:jpa-spring-boot-starter")
    implementation("com.zhaojj11.jam.protobuf:user")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("javax.xml.bind:jaxb-api:2.3.0")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")
    implementation("net.devh:grpc-spring-boot-starter")
    implementation("com.google.protobuf:protobuf-java")
    implementation("com.google.protobuf:protobuf-java-util")
    implementation("io.grpc:grpc-core")
    implementation("io.grpc:grpc-stub")
    implementation("io.grpc:grpc-netty-shaded")
    implementation("io.grpc:grpc-services")
    implementation("io.grpc:grpc-protobuf")
    implementation("commons-codec:commons-codec")

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


