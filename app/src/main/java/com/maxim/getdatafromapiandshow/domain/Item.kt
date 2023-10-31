package com.maxim.getdatafromapiandshow.domain

import com.maxim.getdatafromapiandshow.core.ItemToUiMapper
import com.maxim.getdatafromapiandshow.presenatiton.BaseUiItem
import com.maxim.getdatafromapiandshow.presenatiton.FailureUiItem
import com.maxim.getdatafromapiandshow.presenatiton.UiItem

sealed class Item: ItemToUiMapper {
    class Success(private val text: String): Item() {
        override fun map(): UiItem {
            return BaseUiItem(text)
        }
    }

    class Failed(private val failure: BaseFailure) : Item() {
        override fun map(): UiItem {
            return FailureUiItem(failure.getMessage())
        }
    }
}