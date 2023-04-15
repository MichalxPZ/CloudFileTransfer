package messaging

import core.model.Message

class AwsMessageClient(): IMessageClient {
    override fun getMessages(): List<Message> {
        println("get message for aws")
        return listOf(Message(1, "content1"), Message(2, "content2"))
    }

    override fun sendMessage(message: Message) {
        println("send message for aws")
    }

    override fun completeMessage(message: Message) {
        println("complete message for aws")
    }
}