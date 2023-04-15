package clientFactories

import decryption.IDecryptor
import storage.IStorageClient

interface IStorageClientFactory {
    fun create(): IStorageClient
    fun create(decryptor: IDecryptor): IStorageClient

}