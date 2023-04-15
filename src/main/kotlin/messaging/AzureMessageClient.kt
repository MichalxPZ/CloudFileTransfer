package messaging

import core.model.Message

class AzureMessageClient(): IMessageClient {
    override fun getMessages(): List<Message> {
        println("get message for azure")
        return listOf(Message(1, "content1"), Message(2, "content2"))
    }

    override fun sendMessage(message: Message) {
        println("send message for azure")
    }

    override fun completeMessage(message: Message) {
        println("complete message for azure")
    }
}