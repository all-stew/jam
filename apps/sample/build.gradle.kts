plugins {
    id("com.zhaojj11.jam.spring-boot-application")
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

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.jacocoTestReport.configure {
    enabled = true
}