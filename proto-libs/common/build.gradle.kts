plugins {
    id("com.zhaojj11.jam.protobuf")
}

tasks.named<Copy>("copyProto") {
    from(layout.projectDirectory.dir("../../proto/jam/common"))
    into(layout.projectDirectory.dir("src/main/proto/jam/common"))
}

dependencies {
    implementation(files("../../proto"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}
