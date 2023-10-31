package com.maxim.getdatafromapiandshow.domain

import com.maxim.getdatafromapiandshow.core.net.CloudDataSource
import com.maxim.getdatafromapiandshow.core.DataModelToItemMapper
import com.maxim.getdatafromapiandshow.core.FailureHandler
import com.maxim.getdatafromapiandshow.core.Interactor

class BaseInteractor(
    private val cloudDataSource: CloudDataSource,
    private val failureHandler: FailureHandler,
    private val dataToItemMapper: DataModelToItemMapper
): Interactor {
    override suspend fun getItem(): Item {
        return try {
            cloudDataSource.getItem().map(dataToItemMapper)
        } catch (e: Exception) {
            Item.Failed(failureHandler.handle(e))
            //throw e
        }
    }
}