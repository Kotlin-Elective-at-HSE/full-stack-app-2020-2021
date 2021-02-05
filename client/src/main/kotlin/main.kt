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

            val data = decode(it.data as String)

            val newEntry = when (data) {
                is Message -> "From ${data.senderId}: ${data.message}"
                is Connected -> "User ${data.id} connected"
                is Disconnected -> "User ${data.id} disconnected"
            }

            div.innerHTML = "$newEntry<br>${div.innerHTML}"  // XSS

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
