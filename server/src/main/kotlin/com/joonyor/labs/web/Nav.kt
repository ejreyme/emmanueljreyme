package com.joonyor.labs.web

import kotlinx.html.*

fun FlowContent.nav() = nav {
    classes = setOf("navbar", "navbar-expand-lg", "navbar-light", "bg-white", "py-3")
    div {
        classes = setOf("container", "px-5")
        a {
            classes = setOf("navbar-brand")
            href = "/"
            attributes["hx-get"]="/"
            attributes["hx-target"]="#content"
            attributes["hx-push-url"]="true"
            span {
                classes = setOf("fw-bolder", "text-primary")
                +"CV"
            }
        }
        button {
            classes = setOf("navbar-toggler")
            type = ButtonType.button
            attributes["data-bs-toggle"] = "collapse"
            attributes["data-bs-target"] = "#navbarSupportedContent"
            attributes["aria-controls"] = "navbarSupportedContent"
            attributes["aria-expanded"] = "false"
            attributes["aria-label"] = "Toggle navigation"
            span {
                classes = setOf("navbar-toggler-icon")
            }
        }
        div {
            classes = setOf("collapse", "navbar-collapse")
            id = "navbarSupportedContent"
            ul {
                classes = setOf("navbar-nav", "ms-auto", "mb-2", "mb-lg-0", "small", "fw-bolder")
                li {
                    classes = setOf("nav-item")
                    a {
                        href = "/"
                        attributes["hx-get"]="/"
                        attributes["hx-target"]="#content"
                        attributes["hx-push-url"]="true"
                        classes = setOf("nav-link")
                        +"Home"
                    }
                }
                if (Me.showResume) {
                    li {
                        classes = setOf("nav-item")
                        a {
                            href = "/resume"
                            attributes["hx-get"]="/resume"
                            attributes["hx-target"]="#content"
                            attributes["hx-push-url"]="true"
                            classes = setOf("nav-link")
                            +"Resume"
                        }
                    }
                    li {
                        classes = setOf("nav-item")
                        a {
                            href = "/projects"
                            attributes["hx-get"]="/projects"
                            attributes["hx-target"]="#content"
                            attributes["hx-push-url"]="true"
                            classes = setOf("nav-link")
                            +"Projects"
                        }
                    }
                    li {
                        classes = setOf("nav-item")
                        a {
                            href = "/contact"
                            attributes["hx-get"]="/contact"
                            attributes["hx-target"]="#content"
                            attributes["hx-push-url"]="true"
                            classes = setOf("nav-link")
                            +"Contact"
                        }
                    }
                }
            }
        }
    }
}