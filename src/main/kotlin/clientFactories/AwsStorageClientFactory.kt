package clientFactories

import decryption.StorageClientDecryptionDecorator
import decryption.IDecryptor
import storage.AwsStorageClient
import storage.IStorageClient

class AwsStorageClientFactory: IStorageClientFactory {
    override fun create(): IStorageClient {
        return AwsStorageClient()
    }

    override fun create(decryptor: IDecryptor): IStorageClient {
        return StorageClientDecryptionDecorator(AwsStorageClient(), decryptor)
    }
}