
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
}

application {
    mainClass = "io.ktor.server.netty.EngineMain"

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

tasks.withType<ProcessResources> {
    val wasmOutput = file("../web/build/dist/wasmJs/productionExecutable")
    if (wasmOutput.exists()) {
        inputs.dir(wasmOutput)
    }

    from("../web/build/dist/wasmJs/productionExecutable") {
        into("web")
        include("**/*")
    }
    duplicatesStrategy = DuplicatesStrategy.WARN
}

tasks.register<GradleBuild>("cleanBuildPublish") {
    tasks = listOf("clean", "build", "buildFatJar", "buildImage", "publishImageToLocalRegistry")
}


dependencies {
    implementation(libs.ktor.server.html.builder)
    implementation(libs.kotlinx.html)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.compression)
    implementation(libs.ktor.server.rate.limit)
    implementation(libs.ktor.server.status.pages)
    implementation(libs.ktor.server.caching.headers)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
}
