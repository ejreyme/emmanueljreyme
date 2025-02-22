plugins {
    base
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.ktor) apply false
}

subprojects {
    repositories {
        mavenCentral()
    }

    group = "com.joonyor.labs"
    version = "0.0.1"
}
