package dataFlows

import core.model.DataItem
import core.model.File
import storage.IStorageClient

class StorageToStorageDataFlow(
    private val sourceStorageClient: IStorageClient,
    private val destinationStorageClient: IStorageClient
): DataFlow() {
    override fun getDataItem(): List<DataItem> {
        return sourceStorageClient.getFiles()
            .map { item ->
                DataItem(1, "${item.name}: ${item.content}")
            }
    }

    override fun processDataItem(dataItem: DataItem) {
        destinationStorageClient.createFile(File(dataItem.id.toString(), dataItem.content))
    }

    override fun completeDataItem(dataItem: DataItem) {
        sourceStorageClient.deleteFile(File(dataItem.id.toString(), dataItem.content))
    }
}