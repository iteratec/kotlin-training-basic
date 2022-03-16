import org.jetbrains.kotlin.cli.jvm.main
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    java
}

group = "de.iteratec"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:1.6.0")
    implementation("org.apache.pdfbox:pdfbox:2.0.25")
    implementation("junit:junit:4.13.2")
}

val compileKotlin: KotlinCompile by tasks
val compileTestKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions {
    jvmTarget = "11"
}
compileTestKotlin.kotlinOptions {
    jvmTarget = "11"
}

sourceSets {
    main {
        java.srcDirs("src/main/kotlin")
    }
}

tasks {
    withType<JavaCompile> {
        options.fork(mapOf(Pair("jvmArgs", listOf("--add-opens", "jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED"))))
    }
}
