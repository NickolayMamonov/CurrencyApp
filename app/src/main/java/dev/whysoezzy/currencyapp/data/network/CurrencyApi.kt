package dev.whysoezzy.currencyapp.data.network

import dev.whysoezzy.currencyapp.data.entity.ResponseDTO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CurrencyApi {
    @GET("/daily_json.js")
    suspend fun getLatestCurrencies(): ResponseDTO

}