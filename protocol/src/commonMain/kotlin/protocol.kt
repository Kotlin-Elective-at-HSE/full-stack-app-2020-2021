import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
sealed class ToClientEvent

@Serializable
data class Message(val senderId: Int, val message: String) : ToClientEvent()

@Serializable
data class Connected(val id: Int) : ToClientEvent()

@Serializable
data class Disconnected(val id: Int) : ToClientEvent()

private val json = Json.Default

fun decode(message: String): ToClientEvent {
    return json.decodeFromString(ToClientEvent.serializer(), message)
}

fun encode(message: ToClientEvent): String {
    return json.encodeToString(ToClientEvent.serializer(), message)
}
