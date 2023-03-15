plugins {
    id("com.zhaojj11.jam.spring-boot-library")
    id("io.freefair.lombok") version "6.5.1"
}

group = "${group}.libs"


dependencies {

    implementation(project(":core"))

    implementation("org.springframework:spring-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}