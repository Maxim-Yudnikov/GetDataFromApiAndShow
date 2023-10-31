package com.maxim.getdatafromapiandshow.domain.net

import com.google.gson.annotations.SerializedName
import com.maxim.getdatafromapiandshow.core.net.ServerModelToDataModelMapper
import com.maxim.getdatafromapiandshow.domain.DataModel

data class FactServerModel(
    @SerializedName("fact")
    private val fact: String
) : ServerModelToDataModelMapper {
    override fun map(): DataModel {
        return DataModel(fact)
    }
}