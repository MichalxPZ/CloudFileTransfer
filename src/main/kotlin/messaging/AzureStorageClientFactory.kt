package messaging

import clientFactories.IStorageClientFactory
import decryption.StorageClientDecryptionDecorator
import decryption.IDecryptor
import storage.AzureStorageClient
import storage.IStorageClient

class AzureStorageClientFactory: IStorageClientFactory {
    override fun create(): IStorageClient {
        return AzureStorageClient()
    }

    override fun create(decryptor: IDecryptor): IStorageClient {
        return StorageClientDecryptionDecorator(AzureStorageClient(), decryptor)
    }
}