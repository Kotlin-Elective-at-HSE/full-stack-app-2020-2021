import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.WebSocket
import org.w3c.dom.url.URL

fun main() {
    val url = URL(window.location.href).searchParams.get("ws")!!

    val ws = WebSocket("ws://$url").apply {
        onopen = {
            println("connected")
        }

        onmessage = {
            val div = document.getElementById("history") as HTMLDivElement

            div.innerHTML = "${it.data as String}<br>${div.innerHTML}"  // XSS

            Unit
        }
    }

    (document.getElementById("send") as HTMLInputElement).apply {
        onclick = {
            val message = (document.getElementById("message") as HTMLInputElement).value
            ws.send(message)
        }
    }
}
