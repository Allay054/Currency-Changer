package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.historicalData.adapter

import androidx.lifecycle.MutableLiveData
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ConversionHistoryModel

class HistoryItemViewModel(model: ConversionHistoryModel) {
    val from = MutableLiveData("From : " + model.from)
    val to = MutableLiveData("To : " + model.to)
    val amount = MutableLiveData("Amount : " + model.amount)
    val rate = MutableLiveData("Rate : " + model.rate)
    val strDate = MutableLiveData("Date : " + model.strDate)
    val result = MutableLiveData("Result : " + model.result)
}