import com.joonyor.labs.web.Me
import kotlinx.html.*

fun FlowContent.footerSection() = footer {
    classes = setOf("bg-white py-4 mt-auto")
    div {
        classes = setOf("container px-5")
        div {
            classes = setOf("row align-items-center justify-content-between flex-column flex-sm-row")
            div {
                classes = setOf("col-auto")
                div {
                    classes = setOf("small m-0")
                    +Me.footerText
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