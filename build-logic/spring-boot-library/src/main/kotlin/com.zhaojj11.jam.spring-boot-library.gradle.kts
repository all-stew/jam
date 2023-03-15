plugins {
    id("com.zhaojj11.jam.java-library")
    id("io.freefair.lombok")
}

dependencies {
    implementation(platform("com.zhaojj11.jam.platform:spring-boot-platform"))
}
