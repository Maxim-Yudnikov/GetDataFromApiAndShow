package com.maxim.getdatafromapiandshow.core

import com.maxim.getdatafromapiandshow.domain.Item

interface Interactor {
    suspend fun getItem(): Item
}