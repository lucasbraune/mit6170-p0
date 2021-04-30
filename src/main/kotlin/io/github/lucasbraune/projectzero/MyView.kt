package io.github.lucasbraune.projectzero

import kotlinx.html.*
import kotlinx.html.stream.appendHTML

fun basicHtmlTemplate(title: String, body: FlowContent.() -> Unit): String = buildString {
    appendLine("<!DOCTYPE html>")
    appendHTML().html {
        lang = "en"
        head {
            meta { charset = "UTF-8" }
            meta {
                name = "viewport"
                content = "width=device-width, initial-scale=1"
            }
            title { +title }
            link {
                href = "bootstrap.css"
                rel = "stylesheet"
            }
        }
        body {
            div(classes = "container") {
                body()
            }
        }
    }
}

fun helloPage(): String = basicHtmlTemplate("Hello Page") {
    div {
        h1 { +"Dynamic hello!" }
        hr {}
    }
    div {
        p { +"First paragraph" }
        p {
            +"Second paragraph with sample "
            a("http://www.google.com") { +"link" }
            +"."
        }
    }
    div {
        myTable()
    }
}

private fun FlowContent.myTable() {
    table(classes = "table table-striped") {
        tr {
            th { +"Object" }
            th { +"Description" }
        }
        tr {
            td { +"Ferrari" }
            td { +"Expensive car" }
        }
        tr {
            td { +"macOS" }
            td { +"Operating system" }
        }
    }
}