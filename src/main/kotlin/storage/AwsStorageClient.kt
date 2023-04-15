package storage

import core.model.File

class AwsStorageClient: IStorageClient {
    init {
        println("created aws storage client")
    }

    override fun getFiles(): List<File> {
        println("aws: getFiles")
        val files: List<File> = listOf(File("file1", "content1"), File("file2", "content2"))
        return files
    }

    override fun createFile(file: File) {
        println("aws: createFile")
    }

    override fun deleteFile(file: File) {
        println("aws: deleteFile")
    }
}