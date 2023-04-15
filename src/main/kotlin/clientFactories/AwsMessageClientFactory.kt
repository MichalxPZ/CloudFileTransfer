package clientFactories

import messaging.AwsMessageClient
import messaging.IMessageClient

class AwsMessageClientFactory: IMessageClientFactory {
    override fun create(): IMessageClient {
        return AwsMessageClient()
    }
}