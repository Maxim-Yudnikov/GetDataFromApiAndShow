package com.maxim.getdatafromapiandshow.domain.net

import com.maxim.getdatafromapiandshow.domain.DataModel
import com.maxim.getdatafromapiandshow.domain.NoConnectionException
import com.maxim.getdatafromapiandshow.domain.ServiceUnavailableException
import com.maxim.getdatafromapiandshow.core.net.CloudDataSource
import com.maxim.getdatafromapiandshow.core.net.FactService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class BaseCloudDataSource(
    private val service: FactService
) : CloudDataSource {
    override suspend fun getItem(): DataModel = withContext(Dispatchers.IO) {
        try {
            return@withContext service.getFact().execute().body()!![0].map()
        } catch (e: Exception) {
            if (e is UnknownHostException)
                throw NoConnectionException()
            else {
                throw ServiceUnavailableException()
            }
        }
    }
}