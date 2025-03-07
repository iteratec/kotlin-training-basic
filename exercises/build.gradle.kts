plugins {
    kotlin("jvm") version "2.1.10"
    java
}

group = "de.iteratec"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
    implementation("junit:junit:4.13.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.3")
}

kotlin {
    jvmToolchain(11)
}

sourceSets {
    main {
        java.srcDirs("src/main/kotlin")
    }
    test {
        java.srcDirs("src/test/kotlin")
    }
}
