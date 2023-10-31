package com.maxim.getdatafromapiandshow.domain

import com.maxim.getdatafromapiandshow.core.DataModelToItemMapper

class BaseDataModelToItemMapper: DataModelToItemMapper {
    override fun map(text: String): Item {
        return Item.Success(text)
    }
}