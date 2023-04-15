package storage

import core.model.File

interface IStorageClient {

    fun getFiles(): List<File>
    fun createFile(file: File)
    fun deleteFile(file: File)
}

