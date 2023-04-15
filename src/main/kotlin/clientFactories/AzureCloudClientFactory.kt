package clientFactories

import decryption.IDecryptor
import messaging.AzureMessageClientFactory
import messaging.AzureStorageClientFactory
import messaging.IMessageClient
import storage.IStorageClient

class AzureCloudClientFactory: ICloudClientFactory {
    override fun createStorageClient(): IStorageClient {
        val azureStorageClientFactory = AzureStorageClientFactory()
        return azureStorageClientFactory.create()
    }

    override fun createStorageClient(decryptor: IDecryptor): IStorageClient {
        val azureStorageClientFactory = AzureStorageClientFactory()
        return azureStorageClientFactory.create(decryptor)
    }

    override fun createMessageClient(): IMessageClient {
        val azureMessageClientFactory = AzureMessageClientFactory()
        return azureMessageClientFactory.create()
    }

}