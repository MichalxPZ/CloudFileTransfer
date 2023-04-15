package messaging

import clientFactories.IMessageClientFactory

class AzureMessageClientFactory: IMessageClientFactory {
    override fun create(): IMessageClient {
        return AzureMessageClient()
    }
}