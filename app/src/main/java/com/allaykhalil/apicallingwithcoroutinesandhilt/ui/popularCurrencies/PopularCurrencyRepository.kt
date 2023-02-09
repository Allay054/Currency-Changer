package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.popularCurrencies

import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseRepository
import com.allaykhalil.apicallingwithcoroutinesandhilt.managers.DataManager
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.base.State
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.AllPopularCurrenciesResponse
import javax.inject.Inject

class PopularCurrencyRepository @Inject constructor(dataManager: DataManager) :
    BaseRepository(dataManager) {


    suspend fun getAllPopularCurrency(
        headers: Map<String, String>,
        baseValue: String,
        symbolsValue: String
     ): State<AllPopularCurrenciesResponse> {
        return makeApiCall {
            dataManager.getApiHelper().getLatest(headers, baseValue, symbolsValue)
        }
    }


}