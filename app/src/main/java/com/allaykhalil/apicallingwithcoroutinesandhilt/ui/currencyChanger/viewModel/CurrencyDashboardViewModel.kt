package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.currencyChanger.viewModel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.allaykhalil.apicallingwithcoroutinesandhilt.R
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseViewModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.base.State
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.customModels.MyCustomCurrencySymbols
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ConversionHistoryModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.AllCurrencySymbols
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.AllSymbols
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.ConvertedCurrencyResponse
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.currencyChanger.CurrencyChangerDashboardNavigator
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.currencyChanger.CurrencyDashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CurrencyDashboardViewModel @Inject constructor(var currencyDashboardRepository: CurrencyDashboardRepository) :
    BaseViewModel<CurrencyChangerDashboardNavigator>(currencyDashboardRepository.dataManager) {
    var allCurrencySymbols = MutableLiveData<AllCurrencySymbols>()
    var convertedResult = MutableLiveData<ConvertedCurrencyResponse>()
    var myLiveData: AllSymbols? = null
    val observableArrayList = ObservableArrayList<MyCustomCurrencySymbols>()
    val toValue = MutableLiveData("")
    val fromValue = MutableLiveData("")
    val amountNeedToBeConverted = MutableLiveData("0")

    fun fetchAllCurrencySymbols() {

        viewModelScope.launch {
            makeApiCallForFetchAllSymbols()
            // saveRecordsToDb()
        }
    }

    fun hitConvertCurrencyApi() {

        viewModelScope.launch {
            makeApiCallForConvertCurrency()
            // saveRecordsToDb()
        }
    }

    private suspend fun makeApiCallForFetchAllSymbols() {


        withContext(viewModelScope.coroutineContext) {
            getNavigator()?.showProgressBar()
            val messageLiveData = MutableLiveData<Any>()
            messageLiveData.value = R.string.currency_key


            val headersPost = HashMap<String, String>()
            headersPost["Accept"] = "application/json"
            headersPost["apikey"] = "gp0NF13T2BHyVrYLzluWAegpUkodZQsd"

            when (val request = currencyDashboardRepository.fetchAllSymbolsList(headersPost)) {
                is State.Success -> {
                    getNavigator()?.hideProgressBar()
                    request.wrapperData.let {
                        if (it.success == true) {
                            allCurrencySymbols.value = it
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


    private suspend fun makeApiCallForConvertCurrency() {


        withContext(viewModelScope.coroutineContext) {
            getNavigator()?.showProgressBar()
            val headersPost = HashMap<String, String>()
            headersPost["Accept"] = "application/json"
            headersPost["apikey"] = "gp0NF13T2BHyVrYLzluWAegpUkodZQsd"

            when (val request =
                currencyDashboardRepository.convertCurrency(
                    headersPost, toValue.value.toString(),
                    fromValue.value.toString(),
                    amountNeedToBeConverted.value.toString()
                )) {
                is State.Success -> {
                    getNavigator()?.hideProgressBar()
                    request.wrapperData.let {
                        if (it.success == true) {
                            convertedResult.value = it
                            saveRecordsToDb()
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
        /*allCallList.value?.let {
            if (it.isNotEmpty()) {
                observableArrayList.addAll(it)
            }
        }*/
        allCurrencySymbols.value?.let {
            if (it.success == true) {
                myLiveData = it.allSymbols!!
            }
        }
    }

    private fun saveRecordsToDb() {
        convertedResult.value?.let {

            if (it.success == true) {
                val tempValueModel =
                    ConversionHistoryModel(
                        0,
                        it.queryData!!.from.toString(),
                        it.queryData.to.toString(),
                        it.queryData.amount.toString(),
                        it.infoData!!.timestamp.toString(),
                        it.infoData.rate.toString(),
                        it.strDate.toString(),
                        it.result.toString()
                    )
                viewModelScope.launch(Dispatchers.IO) {
                    dataManager.getDbHelper().insertRecord(tempValueModel)

                }


            }
        }
    }

}