plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(platform("com.zhaojj11.jam.platform:plugins-platform"))

    implementation(project(":commons"))
    implementation("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin")
}
