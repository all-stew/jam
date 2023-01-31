plugins {
    id("com.zhaojj11.jam.java-library")
    id("io.freefair.lombok") version "6.5.1"
}

group = "${group}.libs"


dependencies {
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}