package com.example.com.com.joonyor.lab

import kotlin.js.*
import kotlinx.browser.*

@JsModule("htmx.org")
external object htmx

fun main() {
    document.body?.apply {
        var rowCount = 1
        // Update the total count of items
        addEventListener("htmx:beforeSwap") {
            println("Before swap")
        }
        // Scroll to the bottom of the page after adding content
        addEventListener("htmx:afterSwap") {
            println("After swap")
        }
    }
}
