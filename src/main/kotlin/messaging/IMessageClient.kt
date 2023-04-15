package messaging

import core.model.Message

interface IMessageClient {

    fun getMessages(): List<Message>

    fun sendMessage(message: Message)

    fun completeMessage(message: Message)
}