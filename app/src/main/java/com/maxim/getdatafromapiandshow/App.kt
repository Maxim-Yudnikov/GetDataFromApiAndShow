package com.maxim.getdatafromapiandshow

import android.app.Application
import com.maxim.getdatafromapiandshow.core.net.FactService
import com.maxim.getdatafromapiandshow.presenatiton.BaseCommunication
import com.maxim.getdatafromapiandshow.domain.BaseDataModelToItemMapper
import com.maxim.getdatafromapiandshow.domain.BaseFailureHandler
import com.maxim.getdatafromapiandshow.domain.BaseInteractor
import com.maxim.getdatafromapiandshow.domain.net.BaseCloudDataSource
import com.maxim.getdatafromapiandshow.mocks.MockCloudDataSource
import com.maxim.getdatafromapiandshow.presenatiton.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    lateinit var viewModel: MainViewModel
    private val useMocks = false

    override fun onCreate() {
        super.onCreate()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder().baseUrl("https://www.google.com").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val cloudDataSource = if (useMocks)
            MockCloudDataSource()
        else
            BaseCloudDataSource(retrofit.create(FactService::class.java))
        val interactor =
            BaseInteractor(cloudDataSource, BaseFailureHandler(), BaseDataModelToItemMapper())

        viewModel = MainViewModel(BaseCommunication(), interactor)
    }
}