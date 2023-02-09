package com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels

import com.google.gson.annotations.SerializedName

/**
 * Created by Allay on 3/15/2022
 */
data class ConvertedCurrencyResponse(
    @SerializedName("success")
    val success: Boolean? = false,
    @SerializedName("query")
    val queryData: QueryData? = null,
    @SerializedName("info")
    val infoData: InfoData? = null,
    @SerializedName("date")
    val strDate: String? = null,
    @SerializedName("result")
    val result: String? = null
)

data class QueryData(
    @SerializedName("from")
    val from: String? = null,
    @SerializedName("to")
    val to: String? = null,
    @SerializedName("amount")
    val amount: String? = null
)

data class InfoData(
    @SerializedName("timestamp")
    val timestamp: String? = null,
    @SerializedName("rate")
    val rate: String? = null

)