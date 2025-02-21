package com.joonyor.lab

import com.joonyor.lab.web.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import kotlinx.html.FlowContent
import kotlinx.html.body

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    routing {
        staticResources("/", "/web")
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

suspend fun ApplicationCall.render(component: FlowContent.() -> Unit) {
    respondHtml {
        if (request.headers["HX-Request"] == "true") {
            body { component() }
        } else {
            index(component)
        }
    }
}
