package com.maxim.getdatafromapiandshow.core

import com.maxim.getdatafromapiandshow.domain.Item

interface DataModelToItemMapper {
    fun map(text: String): Item
}