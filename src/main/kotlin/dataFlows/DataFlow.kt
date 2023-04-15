package dataFlows

import core.model.DataItem

abstract class DataFlow {
    fun execute() {
        getDataItem().forEach {dataItem ->
            processDataItem(dataItem)
            completeDataItem(dataItem)
        }
    }

    protected abstract fun getDataItem(): List<DataItem>

    protected abstract fun processDataItem(dataItem: DataItem)

    protected abstract fun completeDataItem(dataItem: DataItem)

}