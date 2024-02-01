plugins {
    id("com.zhaojj11.jam.spring-boot-library")
    id("io.freefair.lombok") version "6.5.1"
    id("checkstyle")
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
