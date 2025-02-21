
plugins {
    kotlin("jvm") version "2.1.10" apply false
    kotlin("multiplatform") version "2.1.10" apply false
    id("io.ktor.plugin") version "3.0.3" apply false
    base
}

subprojects {
    repositories {
        mavenCentral()
    }

    group = "com.example.com"
    version = "0.0.1"
}
