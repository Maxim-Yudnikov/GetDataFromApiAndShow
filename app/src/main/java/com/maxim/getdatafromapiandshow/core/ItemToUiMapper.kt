package com.maxim.getdatafromapiandshow.core

import com.maxim.getdatafromapiandshow.presenatiton.UiItem

interface ItemToUiMapper {
    fun map(): UiItem
}