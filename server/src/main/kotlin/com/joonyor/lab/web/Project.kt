package com.joonyor.lab.web

import kotlinx.html.*

fun FlowContent.project() = div {
    id = "content"
    div { classes = setOf("container px-5 my-5")
        div { classes = setOf("text-center mb-5")
            h1 { +"Projects" }
        }
    }
}