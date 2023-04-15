package clientFactories

import decryption.IDecryptor
import messaging.IMessageClient
import storage.IStorageClient

class AwsCloudClientFactory: ICloudClientFactory {
    override fun createStorageClient(): IStorageClient {
        val awsMessageClientFactory = AwsStorageClientFactory()
        return awsMessageClientFactory.create()
    }

    override fun createStorageClient(decryptor: IDecryptor): IStorageClient {
        val awsMessageClientFactory = AwsStorageClientFactory()
        return awsMessageClientFactory.create(decryptor)
    }

    override fun createMessageClient(): IMessageClient {
        val awsMessageClientFactory = AwsMessageClientFactory()
        return awsMessageClientFactory.create()
    }
}