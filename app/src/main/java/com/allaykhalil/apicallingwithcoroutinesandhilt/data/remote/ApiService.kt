package com.allaykhalil.apicallingwithcoroutinesandhilt.data.remote

import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.AllCurrencySymbols
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.AllPopularCurrenciesResponse
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.ConvertedCurrencyResponse
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.HeaderMap
import retrofit2.http.Query

/*
 * Created by Allay on 02/09/2023
 */

interface ApiService {
    @GET("symbols")
    suspend fun getAllCurrencySymbols(@HeaderMap headers: Map<String, String>): Response<AllCurrencySymbols>

    @GET("convert")
    suspend fun convertAmount(
        @HeaderMap headers: Map<String, String>,
        @Query("to") toValue: String,
        @Query("from") fromValue: String,
        @Query("amount") amountValue: String
    ): Response<ConvertedCurrencyResponse>

    @GET("latest")
    suspend fun getLatest(
        @HeaderMap headers: Map<String, String>,
        @Query("base") baseValue: String,
        @Query("symbols") symbolsValue: String
    ): Response<AllPopularCurrenciesResponse>

}