package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.popularCurrencies.viewModel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseViewModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.base.State
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.customModels.MyCustomCurrencySymbols
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.AllPopularCurrenciesResponse
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.AllRates
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.popularCurrencies.PopularCurrenciesNavigator
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.popularCurrencies.PopularCurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PopularCurrencyViewModel @Inject constructor(var popularCurrencyRepository: PopularCurrencyRepository) :
    BaseViewModel<PopularCurrenciesNavigator>(popularCurrencyRepository.dataManager) {
    var convertedResult = MutableLiveData<AllPopularCurrenciesResponse>()
    var myLiveData: AllRates? = null

    /*  val observableArrayList = ObservableArrayList<MyCustomCurrencySymbols>()*/
    val baseCurrencyValue = MutableLiveData("")
    val symbolsCurrencyValue = MutableLiveData("")
    val obtainedResult = MutableLiveData("")

    fun hitForPopularCurrency() {
        viewModelScope.launch {
            makeApiCallForPopularCurrency()

        }
    }


    private suspend fun makeApiCallForPopularCurrency() {


        withContext(viewModelScope.coroutineContext) {
            getNavigator()?.showProgressBar()
            val headersPost = HashMap<String, String>()
            headersPost["Accept"] = "application/json"
            headersPost["apikey"] = "gp0NF13T2BHyVrYLzluWAegpUkodZQsd"

            when (val request =
                popularCurrencyRepository.getAllPopularCurrency(
                    headersPost, baseCurrencyValue.value.toString(),
                    symbolsCurrencyValue.value.toString()
                )) {
                is State.Success -> {
                    getNavigator()?.hideProgressBar()
                    request.wrapperData.let {
                        if (it.success == true) {
                            convertedResult.value = it
                            /* saveRecordsToDb()*/
                        } else {
                            getNavigator()?.showErrorMessage("No Data Found")
                        }

                    }
                }
                is State.Error -> {
                    getNavigator()?.showErrorMessage(request.responseError.errorMessage)
                    getNavigator()?.hideProgressBar()

                    resetData()
                }
            }
        }
    }

    private fun resetData() {
        /*
        * Function to reset data back to View in case Api call fails
        */

        convertedResult.value?.let {
            if (it.success == true) {
                myLiveData = it.allRates!!
            }
        }
    }


}