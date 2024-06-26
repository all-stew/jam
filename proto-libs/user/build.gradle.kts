plugins {
    id("com.zhaojj11.jam.protobuf")
}

tasks.named<Copy>("copyProto") {
    from(layout.projectDirectory.dir("../../proto/jam/user"))
    into(layout.projectDirectory.dir("src/main/proto/jam/user"))
}

tasks.build {
    dependsOn(":common:build")
}

dependencies {
    implementation(project(":common"))
    implementation(files("../../proto"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}
