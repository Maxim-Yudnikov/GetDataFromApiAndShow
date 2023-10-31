package com.maxim.getdatafromapiandshow.domain

import com.maxim.getdatafromapiandshow.core.FailureHandler
import java.io.IOException

class BaseFailureHandler : FailureHandler {
    override fun handle(e: Exception): BaseFailure {
        return when (e) {
            is NoConnectionException -> NoConnectionError()
            is ServiceUnavailableException -> ServiceUnavailableError()
            else -> UnknownError()
        }
    }
}

class NoConnectionException : IOException()
class ServiceUnavailableException : IOException()