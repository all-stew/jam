plugins {
    id("java-platform")
}

group = "com.zhaojj11.jam.platform"

javaPlatform.allowDependencies()

dependencies {
    api(platform("io.grpc:grpc-bom:1.60.1"))
    api(platform("com.google.protobuf:protobuf-bom:3.25.1"))

    constraints {
        api("com.google.protobuf:protobuf-gradle-plugin:0.9.4")
        api("javax.annotation:javax.annotation-api:1.3.2")
    }
}
