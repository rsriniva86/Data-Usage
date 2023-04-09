package com.demo.datausage.core.data.datasource.remote.di

import com.demo.datausage.core.data.datasource.remote.BuildConfig
import com.demo.datausage.core.data.datasource.remote.DataUsageAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofitBuilder(get(), "https://data.gov.sg/api/") }
    single { provideDataUsageAPI(get()) }
}

private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .build()

private fun provideRetrofitBuilder(
    okHttpClient: OkHttpClient,
    BASE_URL: String
): Retrofit.Builder =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)

private fun provideDataUsageAPI(
    retrofitBuilder: Retrofit.Builder
) = retrofitBuilder
    .build()
    .create(DataUsageAPI::class.java)