package storage

import core.model.File

class AzureStorageClient: IStorageClient {
    init {
        println("created azure storage client")
    }

    override fun getFiles(): List<File> {
        println("azure: getFiles")
        return listOf(File("file1", "content1"), File("file2", "content2"))
    }

    override fun createFile(file: File) {
        println("azure: createFile")
    }

    override fun deleteFile(file: File) {
        println("azure: deleteFile")
    }
}