package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.historicalData.viewModel

import android.annotation.SuppressLint
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseViewModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ConversionHistoryModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.historicalData.HistoryNavigator
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.historicalData.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(var historyRepository: HistoryRepository) :
    BaseViewModel<HistoryNavigator>(historyRepository.dataManager) {
    val allHistoryList = MutableLiveData<List<ConversionHistoryModel>>()
    val observableArrayList = ObservableArrayList<ConversionHistoryModel>()

    @SuppressLint("NewApi")
    fun fetchFromDbClick() {
        if (observableArrayList.size > 0)
            observableArrayList.clear()

       /* val sdf = SimpleDateFormat("YYYY-MM-dd", Locale.ENGLISH)
        val currentDate = sdf.format(Date())
        Log.d("==>", "Current Date: $currentDate")*/

     //   getPreviousDate(currentDate)

        viewModelScope.launch {
            historyRepository.fetchRecordsFromDb().run {

                delay(5)
                if (this != null) {
                    if (this.isNotEmpty()) {
                        allHistoryList.value = this
                       //  getNavigator()?.showSuccessMessage("db list size:" + this.size.toString())


                    } else {
                        getNavigator()?.showSuccessMessage("empty:" + this.size.toString())
                    }
                }
            }


            /*historyRepository.fetchContactsFromDbLastThreeDays().run {

                delay(5)
                if (this != null) {
                    if (this.isNotEmpty()) {
                        allHistoryList.value = this
                        *//* getNavigator()?.showSuccessMessage("db list size:" + this.size.toString())*//*


                    } else {
                        getNavigator()?.showSuccessMessage("empty:" + this.size.toString())
                    }
                }
            }*/
        }
    }

    private fun resetData() {
        /*
        * Function to reset data back to View in case Api call fails
        */
        allHistoryList.value?.let {
            if (it.isNotEmpty()) {
                observableArrayList.addAll(it)
            }
        }
    }

   /* @SuppressLint("NewApi")
    private fun getPreviousDate(inputDate: String): String {
        var inputDate = inputDate
        inputDate = "15-12-2015" // for example
        val format = SimpleDateFormat("YYYY-MM-dd", Locale.ENGLISH)
        try {
            val date: Date = format.parse(inputDate)!!
            val c: Calendar = Calendar.getInstance()
            c.time = date
            c.add(Calendar.DATE, -1)
            inputDate = format.format(c.time)
          //  Log.d("asd", "selected date : $inputDate")
            Log.d("==>", "previous Date: $date")
            println(date)
        } catch (e: Exception) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            inputDate = ""
        }
        return inputDate
    }*/

}