package clientFactories

import messaging.IMessageClient

interface IMessageClientFactory {
    fun create(): IMessageClient
}