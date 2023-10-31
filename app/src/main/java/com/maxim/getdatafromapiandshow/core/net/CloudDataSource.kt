package com.maxim.getdatafromapiandshow.core.net

import com.maxim.getdatafromapiandshow.domain.DataModel

interface CloudDataSource {
    suspend fun getItem(): DataModel
}