package clientFactories

import decryption.IDecryptor
import messaging.IMessageClient
import storage.IStorageClient

interface ICloudClientFactory {

    fun createStorageClient(): IStorageClient
    fun createStorageClient(decryptor: IDecryptor): IStorageClient
    fun createMessageClient(): IMessageClient
}