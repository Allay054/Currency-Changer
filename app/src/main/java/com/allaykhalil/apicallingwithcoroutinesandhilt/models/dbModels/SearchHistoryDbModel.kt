package com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Allay on 3/15/2022
 */

@Entity(tableName = "SearchHistoryData")
data class ConversionHistoryModel(
    @PrimaryKey(autoGenerate = true)
    val dbId: Int=0,
    @SerializedName("from")
    val from: String,
    @SerializedName("to")
    val to: String,
    @SerializedName("amount")
    val amount: String,
    @SerializedName("timestamp")
    val timestamp: String,
    @SerializedName("rate")
    val rate: String,
    @SerializedName("date")
    val strDate: String,
    @SerializedName("result")
    val result: String
)