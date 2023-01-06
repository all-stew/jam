plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(platform("com.zhaojj11.jam.platform:plugins-platform"))

    implementation(project(":commons"))
}
