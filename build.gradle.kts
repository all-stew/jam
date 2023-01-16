plugins {
    id("jacoco")
    id("org.sonarqube") version ("3.5.0.2730")
}

sonarqube {
    properties {
        property("sonar.projectKey", "all-stew_jam")
        property("sonar.organization", "all-stew")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}