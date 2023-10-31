package com.maxim.getdatafromapiandshow.domain

import com.maxim.getdatafromapiandshow.core.DataModelToItemMapper

class DataModel(private val text: String) {
    fun map(mapper: DataModelToItemMapper): Item = mapper.map(text)
}