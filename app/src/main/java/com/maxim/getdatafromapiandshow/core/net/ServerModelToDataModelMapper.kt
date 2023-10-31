package com.maxim.getdatafromapiandshow.core.net

import com.maxim.getdatafromapiandshow.domain.DataModel

interface ServerModelToDataModelMapper {
    fun map(): DataModel
}