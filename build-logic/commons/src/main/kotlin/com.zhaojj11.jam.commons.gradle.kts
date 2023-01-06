plugins {
    id("java")
    id("com.zhaojj11.jam.jacoco")
}

group = "com.zhaojj11.jam"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(platform("com.zhaojj11.jam.platform:product-platform"))

    testImplementation(platform("com.zhaojj11.jam.platform:test-platform"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
