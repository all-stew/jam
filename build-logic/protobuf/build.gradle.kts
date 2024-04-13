plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(platform("com.zhaojj11.jam.platform:proto-platform"))
    implementation(project(":java-library"))
    implementation("com.google.protobuf:protobuf-gradle-plugin")
}
