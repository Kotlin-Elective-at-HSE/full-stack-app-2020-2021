import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import java.net.InetSocketAddress

class Server : WebSocketServer(InetSocketAddress(8885)) {

    var nextId = 0

    override fun onOpen(conn: WebSocket, handshake: ClientHandshake) {
        conn.setAttachment(nextId)
        ++nextId
    }

    override fun onClose(conn: WebSocket, code: Int, reason: String, remote: Boolean) {
    }

    override fun onMessage(conn: WebSocket, message: String) {
        val id = conn.getAttachment<Int>()
        val m = "$id: $message"

        connections.forEach {
            if (it.isOpen) {
                it.send(m)
            }
        }
    }

    override fun onError(conn: WebSocket, ex: Exception) {
    }

    override fun onStart() {
    }
}

fun main() {
    Server().start()
}