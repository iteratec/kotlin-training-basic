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
    implementation(libs.kotlinx.coroutines)
    implementation(libs.junit.junit)
    implementation(libs.jackson.kotlin)
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
