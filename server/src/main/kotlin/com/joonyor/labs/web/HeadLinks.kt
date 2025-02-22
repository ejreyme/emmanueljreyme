import kotlinx.html.FlowContent
import kotlinx.html.HEAD
import kotlinx.html.link

fun HEAD.headLinks() {
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
}