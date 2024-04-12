plugins {
    id("java")
}

group = "com.zhaojj11.jam"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    implementation(platform("com.zhaojj11.jam.platform:product-platform"))

    testImplementation(platform("com.zhaojj11.jam.platform:test-platform"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
