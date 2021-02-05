import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import java.net.InetSocketAddress

class Server : WebSocketServer(InetSocketAddress(8885)) {

    var nextId = 0

    private fun sendToAll(message: ToClientEvent) {
        val data = encode(message)

        connections.forEach {
            if (it.isOpen) {
                it.send(data)
            }
        }
    }

    override fun onOpen(conn: WebSocket, handshake: ClientHandshake) {
        conn.setAttachment(nextId)
        ++nextId  // bad in terms of concurrency

        val id: Int = conn.getAttachment()
        sendToAll(Connected(id))
    }

    override fun onClose(conn: WebSocket, code: Int, reason: String, remote: Boolean) {
        val id: Int = conn.getAttachment()
        sendToAll(Disconnected(id))
    }

    override fun onMessage(conn: WebSocket, message: String) {
        val id: Int = conn.getAttachment()
        sendToAll(Message(id, message))
    }

    override fun onError(conn: WebSocket, ex: Exception) {
    }

    override fun onStart() {
    }
}

fun main() {
    Server().start()
}