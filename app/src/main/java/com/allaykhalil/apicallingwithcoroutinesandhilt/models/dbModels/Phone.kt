package com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels

import com.google.gson.annotations.SerializedName

data class Phone(
    @SerializedName("home")
    val home: String,
    @SerializedName("mobile")
    val mobile: String,
    @SerializedName("office")
    val office: String
)