plugins {
    id("com.zhaojj11.jam.java-library")
    id("io.freefair.lombok") version "6.5.1"
}

group = "${group}.libs"


dependencies {
    implementation(enforcedPlatform("org.springframework.boot:spring-boot-dependencies:2.7.6"))
    implementation(enforcedPlatform("org.springframework.cloud:spring-cloud-dependencies:2021.0.5"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}