package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.popularCurrencies

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.allaykhalil.apicallingwithcoroutinesandhilt.BR
import com.allaykhalil.apicallingwithcoroutinesandhilt.R
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseActivity
import com.allaykhalil.apicallingwithcoroutinesandhilt.databinding.ActivityPopularCurrencyDashboardBinding
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.dashboard.DashBoard
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.popularCurrencies.viewModel.PopularCurrencyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularCurrencyDashboard :
    BaseActivity<PopularCurrencyViewModel, ActivityPopularCurrencyDashboardBinding>(R.layout.activity_popular_currency_dashboard),
    PopularCurrenciesNavigator {

    override val viewModel: PopularCurrencyViewModel by viewModels()
    val sb = StringBuilder()


    override fun getBindingVariable() = BR.viewModel

    var baseStrValue: String = ""
    var symbolsStrValue: String = ""

    override fun initUi() {
        viewModel.setNavigator(this)


        viewModel.convertedResult.observe(
            this
        ) {


            sb.append("Base Value:EUR")
                .append("\n")
                .append("AFN Rate:" + viewModel.convertedResult.value!!.allRates!!.AFN.toString())
                .append("\n")
                .append("ALL Rate:" + viewModel.convertedResult.value!!.allRates!!.ALL.toString())
                .append("\n")
                .append("AMD Rate:" + viewModel.convertedResult.value!!.allRates!!.AMD.toString())
                .append("\n")
                .append("ANG Rate:" + viewModel.convertedResult.value!!.allRates!!.ANG.toString())
                .append("\n")
                .append("AOA Rate:" + viewModel.convertedResult.value!!.allRates!!.AOA.toString())
                .append("\n")
                .append("ARS Rate:" + viewModel.convertedResult.value!!.allRates!!.ARS.toString())
                .append("\n")

            viewModel.obtainedResult.value = sb.toString()

            Toast.makeText(
                this@PopularCurrencyDashboard,
                viewModel.convertedResult.value!!.allRates!!.ARS.toString(),
                Toast.LENGTH_SHORT
            ).show()


        }


        bindings.apply {
            lifecycleOwner = this@PopularCurrencyDashboard
            viewModel = this@PopularCurrencyDashboard.viewModel

            getPopularCurrency = View.OnClickListener {
                baseStrValue = "EUR"
                symbolsStrValue = "AED,AFN,ALL,AMD,ANG,AOA,ARS"
                viewModel!!.baseCurrencyValue.value = baseStrValue.toString()
                viewModel!!.symbolsCurrencyValue.value = symbolsStrValue

                viewModel!!.hitForPopularCurrency()
            }
        }


    }

    override fun onBackPressed() {
        val intent = Intent(this@PopularCurrencyDashboard, DashBoard::class.java)
        startActivity(intent)
        finish()
    }


}