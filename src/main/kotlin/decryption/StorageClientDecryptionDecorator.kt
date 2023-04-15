package decryption

import storage.IStorageClient
import core.model.File

class StorageClientDecryptionDecorator(
    val storageClient: IStorageClient,
    val decryptor: IDecryptor
): IStorageClient {
    override fun getFiles(): List<File> {
        val files = storageClient.getFiles()
        files.forEach {file ->
            file.content = decryptor.decrypt(file.content)
        }
        return files
    }

    override fun createFile(file: File) {
        storageClient.createFile(file)
    }

    override fun deleteFile(file: File) {
        storageClient.deleteFile(file)
    }

}