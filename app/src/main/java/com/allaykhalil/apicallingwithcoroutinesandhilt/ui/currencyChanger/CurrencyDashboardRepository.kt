package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.currencyChanger

import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseRepository
import com.allaykhalil.apicallingwithcoroutinesandhilt.managers.DataManager
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.base.State
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ConversionHistoryModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.AllCurrencySymbols
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.ConvertedCurrencyResponse
import javax.inject.Inject

class CurrencyDashboardRepository @Inject constructor(dataManager: DataManager) :
    BaseRepository(dataManager) {

    suspend fun fetchAllSymbolsList(headers: Map<String, String>): State<AllCurrencySymbols> {
        return makeApiCall {
            dataManager.getApiHelper().getAllCurrencySymbols(headers)
        }
    }

    suspend fun convertCurrency(
        headers: Map<String, String>,
        toValue: String,
        fromValue: String,
        amountValue: String
     ): State<ConvertedCurrencyResponse> {
        return makeApiCall {
            dataManager.getApiHelper().convertAmount(headers, toValue, fromValue, amountValue)
        }
    }

}