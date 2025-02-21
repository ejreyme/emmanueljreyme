package com.joonyor.lab.web


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
fun HTML.index(component: FlowContent.() -> Unit = {}) {
    head {
        meta {
            charset = "utf-8"
        }
        meta {
            name = "viewport"
            content = "width=device-width, initial-scale=1, shrink-to-fit=no"
        }
        meta {
            name = "description"
            content = ""
        }
        meta {
            name = "author"
            content = ""
        }
        title { +"Personal - Start Bootstrap Theme" }
        // Favicon
        link {
            rel = "icon"
            type = "image/x-icon"
            href = "assets/favicon.ico"
        }
        // Custom Google font
        link {
            rel = "preconnect"
            href = "https://fonts.googleapis.com"
        }
        link {
            rel = "preconnect"
            href = "https://fonts.gstatic.com"
            attributes["crossorigin"] = ""
        }
        link {
            href = "https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@100;200;300;400;500;600;700;800;900&display=swap"
            rel = "stylesheet"
        }
        // Bootstrap icons
        link {
            href = "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css"
            rel = "stylesheet"
        }
        // Core theme CSS (includes Bootstrap)
        link {
            href = "css/styles.css"
            rel = "stylesheet"
        }
        script(src = "/web.js") {}
    }
    body { classes = setOf("d-flex flex-column h-100")
        main { classes = setOf("flex-shrink-0")
            nav()
            component()
        }
        footer()
        script {
            src = ("https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js")
        }
    }
}
fun FlowContent.footer() = footer {
    classes = setOf("bg-white py-4 mt-auto")
    div {
        classes = setOf("container px-5")
        div {
            classes = setOf("row align-items-center justify-content-between flex-column flex-sm-row")
            div {
                classes = setOf("col-auto")
                div {
                    classes = setOf("small m-0")
                    +"Copyright © Emmanuel J. Reyme 2025"
                }
            }
            if (Me.showResume) {
                div {
                    classes = setOf("col-auto")
                    a {
                        classes = setOf("small")
                        href = "#!"
                        +"Privacy"
                    }
                    span {
                        classes = setOf("mx-1")
                        +"·"
                    }
                    a {
                        classes = setOf("small")
                        href = "#!"
                        +"Terms"
                    }
                    span {
                        classes = setOf("mx-1")
                        +"·"
                    }
                    a {
                        classes = setOf("small")
                        href = "#!"
                        +"Contact"
                    }
                }
            }
        }
    }
}
