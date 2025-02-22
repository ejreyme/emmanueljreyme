package com.joonyor.labs.web

import kotlinx.html.*

fun FlowContent.resume() = div {
    id = "content"
    div { classes = setOf("container px-5 my-5")
        div { classes = setOf("text-center mb-5")
            h1 { classes = setOf("display-5 fw-bolder mb-0")
                span { classes = setOf("text-gradient", "d-inline")
                    +"Resume"
                }
            }
        }
        div { classes = setOf("row gx-5 justify-content-center")
            div { classes = setOf("col-lg-11 col-xl-9 col-xxl-8")
                summary()
                skills()
                experience()
                education()
                div { classes = setOf("pd-5") }
            }
        }
    }
}

fun FlowContent.summary() = section {
    div { classes = setOf("d-flex align-items-center justify-content-between mb-4")
        h2(classes = "text-primary fw-bolder mb-0") {
            +"Summary"
        }
    }
    div { classes = setOf("card shadow border-0 rounded-4 mb-5")
        div { classes = setOf("card-body p-5")
            div { classes = setOf("row align-items-center gx-5")
                div { classes = setOf("col-lg-8")
                    +"Summary"
                }
            }
        }
    }
}
fun FlowContent.experience() = section {
    div { classes = setOf("d-flex align-items-center justify-content-between mb-4")
        h2(classes = "text-primary fw-bolder mb-0") {
            +"Work Experience"
        }
    }
    div { classes = setOf("card shadow border-0 rounded-4 mb-5")
        div { classes = setOf("card-body p-5")
            div { classes = setOf("row align-items-center gx-5")
                div { classes = setOf("col text-center text-lg-start mb-4 mb-lg-0")
                    div { classes = setOf("bg-light p-4 rounded-4")
                        div { classes = setOf("text-primary fw-bolder mb-2")
                            +"date"
                        }
                        div { classes = setOf("small fw-bolder")
                            +"position"
                        }
                        div { classes = setOf("small text-muted")
                            +"company"
                        }
                        div { classes = setOf("small text-muted")
                            +"location"
                        }
                    }
                }
            }
        }
    }
}
fun FlowContent.education() = section {
    div { classes = setOf("d-flex align-items-center justify-content-between mb-4")
        h2(classes = "text-primary fw-bolder mb-0") {
            +"Education"
        }
    }
    div { classes = setOf("card shadow border-0 rounded-4 mb-5")
        div { classes = setOf("card-body p-5")
            div { classes = setOf("row align-items-center gx-5")
                div { classes = setOf("col text-center text-lg-start mb-4 mb-lg-0")
                    div { classes = setOf("bg-light p-4 rounded-4")
                        div { classes = setOf("text-primary fw-bolder mb-2")
                            +"date"
                        }
                        div { classes = setOf("small fw-bolder")
                            +"position"
                        }
                        div { classes = setOf("small text-muted")
                            +"company"
                        }
                        div { classes = setOf("small text-muted")
                            +"location"
                        }
                    }
                }
            }
        }
    }
}
fun FlowContent.skills() = section {
    div { classes = setOf("d-flex align-items-center justify-content-between mb-4")
        h2(classes = "text-primary fw-bolder mb-0") {
            +"Technical Skills"
        }
    }
    div { classes = setOf("card shadow border-0 rounded-4 mb-5")
        div { classes = setOf("card-body p-5")
            div { classes = setOf("row align-items-center gx-5")
                div { classes = setOf("col text-center text-lg-start mb-4 mb-lg-0")
                    div { classes = setOf("bg-light p-4 rounded-4")
                        div { classes = setOf("text-primary fw-bolder mb-2")
                            +"date"
                        }
                        div { classes = setOf("small fw-bolder")
                            +"position"
                        }
                        div { classes = setOf("small text-muted")
                            +"company"
                        }
                        div { classes = setOf("small text-muted")
                            +"location"
                        }
                    }
                }
            }
        }
    }
}