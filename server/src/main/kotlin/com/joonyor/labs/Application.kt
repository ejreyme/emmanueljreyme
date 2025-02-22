package com.joonyor.labs

import com.joonyor.labs.web.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.cachingheaders.*
import io.ktor.server.plugins.compression.*
import io.ktor.server.plugins.ratelimit.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.FlowContent
import kotlinx.html.body
import java.time.ZonedDateTime
import kotlin.time.Duration.Companion.seconds

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    install(Compression) {
        gzip() {
            /**
             * HTTPS with the enabled compression is vulnerable to the BREACH attack.
             * Mitigate this attack; disable compression whenever the referrer header indicates a cross-site request.
             */
            condition {
                request.headers[HttpHeaders.Referrer]?.startsWith("https://emmanueljreyme.com/") == true
            }
        }
    }
    install(RateLimit) {
        register(RateLimitName("public")) {
            rateLimiter(limit = 15, refillPeriod = 10.seconds)
        }
    }
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause" , status = HttpStatusCode.InternalServerError)
        }
        status(HttpStatusCode.TooManyRequests) { call, status ->
            val retryAfter = call.response.headers["Retry-After"]
            call.respondText(text = "429: Too many requests. Wait for $retryAfter seconds.", status = status)
        }
    }
    routing {
        install(CachingHeaders) {
            options { call, content ->
                when (content.contentType?.withoutParameters()) {
                    ContentType.Text.JavaScript -> io.ktor.http.content.CachingOptions(CacheControl.MaxAge(maxAgeSeconds = 3600))
                    ContentType.Text.CSS -> io.ktor.http.content.CachingOptions(CacheControl.MaxAge(maxAgeSeconds = 3600))
                    ContentType.Image.PNG -> io.ktor.http.content.CachingOptions(CacheControl.MaxAge(maxAgeSeconds = 3600))
                    ContentType.Image.XIcon -> io.ktor.http.content.CachingOptions(CacheControl.MaxAge(maxAgeSeconds = 3600))

                    else -> null
                }
            }
        }
        staticResources("/", "/web")
        rateLimit(RateLimitName("public")) {
            get("/") {
                call.render { home() }
            }
            get("/resume") {
                call.render { resume() }
            }
            get("/projects") {
                call.render { project() }
            }
            get("/contact") {
                call.render { contact() }
            }
        }
    }
}

suspend fun ApplicationCall.render(component: FlowContent.() -> Unit) {
    respondHtml {
        if (request.headers["HX-Request"] == "true") {
            body { component() }
        } else {
            index(component)
        }
    }
}
