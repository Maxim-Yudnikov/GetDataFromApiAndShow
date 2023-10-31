package com.maxim.getdatafromapiandshow.mocks

import com.maxim.getdatafromapiandshow.core.net.CloudDataSource
import com.maxim.getdatafromapiandshow.domain.DataModel

class MockCloudDataSource: CloudDataSource {
    private var count = 0
    override suspend fun getItem(): DataModel {
        count++
        return DataModel("fact$count")
    }
}