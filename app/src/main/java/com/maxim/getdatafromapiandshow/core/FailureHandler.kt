package com.maxim.getdatafromapiandshow.core

import com.maxim.getdatafromapiandshow.domain.BaseFailure

interface FailureHandler {
    fun handle(e: Exception): BaseFailure
}