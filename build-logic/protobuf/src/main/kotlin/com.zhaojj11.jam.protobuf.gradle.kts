import org.gradle.plugins.ide.idea.model.IdeaModel

plugins {
    id("com.zhaojj11.jam.java-library")
    id("com.google.protobuf")
    id("idea")
}

group = "${group}.protobuf"

dependencies {
    implementation("com.google.protobuf:protobuf-java")
    implementation("io.grpc:grpc-stub")
    implementation("io.grpc:grpc-protobuf")
    implementation("javax.annotation:javax.annotation-api")
}

sourceSets {
    main {
        java {
            srcDir("src/main/grpc")
        }
    }
}

protobuf {
    protoc {
        if (System.getenv("PROTO_BINARY_USE_LOCAL") != "true") {
            artifact = "com.google.protobuf:protoc:3.25.1"
            repositories {
                mavenCentral()
            }
        } else {
            path = "/usr/local/bin/protoc"
        }
    }
    plugins {
        register("grpc") {
            if (System.getenv("PROTO_BINARY_USE_LOCAL") != "true") {
                artifact = "io.grpc:protoc-gen-grpc-java:1.64.0"
                repositories {
                    mavenCentral()
                }
            } else {
                path = "/usr/local/bin/protoc-gen-grpc-java"
            }
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach { task ->
            task.plugins {
                register("grpc")
            }
        }
    }
}

val shouldBuildProto = properties["buildProto"]?.toString() == "true" || true

tasks.register<Copy>("copyProto") {
    isEnabled = shouldBuildProto
}

tasks.register<Delete>("deleteProto") {
    isEnabled = shouldBuildProto
    project.plugins.withId("idea") {
        val ideaModel = project.extensions.findByType(IdeaModel::class.java)
        if (ideaModel != null) {
            ideaModel.module.sourceDirs.removeIf {
                (it.name == "main" && it.parentFile.name == "extracted-protos")
                        || (it.name == "main" && it.parentFile.name == "extracted-include-protos")
                        || ((it.name == "proto" && it.parentFile.name == "main"))
            }
            ideaModel.module.generatedSourceDirs.removeIf {
                (it.name == "main" && it.parentFile.name == "extracted-protos")
                        || (it.name == "main" && it.parentFile.name == "extracted-include-protos")
                        || ((it.name == "proto" && it.parentFile.name == "main"))
            }
            val excludeDir = ideaModel.module.excludeDirs.firstOrNull {
                it.name == "proto" && it.parentFile.name == "main"
            }
            if (excludeDir == null) {
                ideaModel.module.excludeDirs.add(project.file("src/main/proto"))
            }
        }
    }
}

tasks.extractIncludeProto {
    isEnabled = shouldBuildProto
}
tasks.extractProto {
    isEnabled = shouldBuildProto
    dependsOn("copyProto")
}
tasks.generateProto {
    isEnabled = shouldBuildProto
    finalizedBy("deleteProto")
}

tasks.extractIncludeTestProto {
    isEnabled = false
}
tasks.extractTestProto {
    isEnabled = false
}
tasks.generateTestProto {
    isEnabled = false
}
tasks.processResources {
    isEnabled = false
}
tasks.compileTestJava {
    isEnabled = false
}
tasks.processTestResources {
    isEnabled = false
}
tasks.testClasses {
    isEnabled = false
}
tasks.test {
    isEnabled = false
}

tasks.clean {
    delete += listOf("$projectDir/src")
}
