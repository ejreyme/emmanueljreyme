package com.joonyor.labs.web


import footerSection
import headLinks
import kotlinx.html.*

fun HEAD.meta() {
    meta { charset = "utf-8" }
    meta {
        name = "viewport"
        content = "width=device-width, initial-scale=1, shrink-to-fit=no"
    }
    meta {
        name = "description"
        content = "Emmanuel J. Reyme - CV"
    }
    meta {
        name = "author"
        content = "Emmanuel J. Reyme"
    }
}

fun HTML.index(component: FlowContent.() -> Unit = {}) {
    head {
        title { +"Emmanuel J. Reyme - CV" }
        meta()
        headLinks()
        script(src = "/web.js") {}
    }
    body { classes = setOf("d-flex flex-column h-100")
        main { classes = setOf("flex-shrink-0")
            nav()
            component()
        }
        footerSection()
        script {
            src = ("https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js")
        }
    }
}

