package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.allaykhalil.apicallingwithcoroutinesandhilt.R
import com.allaykhalil.apicallingwithcoroutinesandhilt.databinding.ActivityDashBoardBinding
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.dashboard.viewModel.DashboardViewModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.currencyChanger.CurrencyChangerDashboard
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.historicalData.HistoryActivity
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.popularCurrencies.PopularCurrencyDashboard

class DashBoard : AppCompatActivity() {

    private lateinit var binding: ActivityDashBoardBinding

    private val viewModel: DashboardViewModel by viewModels()

    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory {
        return object : ViewModelProvider.NewInstanceFactory() {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
                    return DashboardViewModel(this@DashBoard) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_dash_board)
        binding.apply {
            lifecycleOwner = this@DashBoard
            viewModel = this@DashBoard.viewModel


            fetchAllCurrencySymbols = View.OnClickListener {
                fetchAllCurrencySymbols()
            }

            fetchAllPopularCurrencies=View.OnClickListener {
                fetchAllPopularCurrencies()
            }
        }

    }



    private fun fetchAllCurrencySymbols() {
        val intent = Intent(this@DashBoard, CurrencyChangerDashboard::class.java)
        startActivity(intent)
        finish()

    /*    val intent = Intent(this@DashBoard, HistoryActivity::class.java)
        startActivity(intent)
        finish()*/
    }

    private fun fetchAllPopularCurrencies() {
        val intent = Intent(this@DashBoard, PopularCurrencyDashboard::class.java)
        startActivity(intent)
        finish()

        /*    val intent = Intent(this@DashBoard, HistoryActivity::class.java)
            startActivity(intent)
            finish()*/
    }


}

