package com.maxim.getdatafromapiandshow.core.net

import com.maxim.getdatafromapiandshow.domain.net.FactServerModel
import retrofit2.Call
import retrofit2.http.GET

interface FactService {
    @GET("https://api.api-ninjas.com/v1/facts?X-api-key=zby0v4LYDh04KmIxgbPZqw==CLlxL9Aqcl6PGNyP")
    fun getFact(): Call<List<FactServerModel>>
}