package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.historicalData

import android.content.Intent
import androidx.activity.viewModels
import com.allaykhalil.apicallingwithcoroutinesandhilt.BR
import com.allaykhalil.apicallingwithcoroutinesandhilt.R
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseActivity
import com.allaykhalil.apicallingwithcoroutinesandhilt.databinding.ActivityHistoryBinding
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.currencyChanger.CurrencyChangerDashboard
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.historicalData.adapter.HistoryAdapter
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.historicalData.viewModel.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryActivity :
    BaseActivity<HistoryViewModel, ActivityHistoryBinding>(R.layout.activity_history),
    HistoryNavigator {
    @Inject
    lateinit var adapter: HistoryAdapter

    override val viewModel: HistoryViewModel by viewModels()

    override fun getBindingVariable() = BR.viewModel

    override fun initUi() {
        viewModel.setNavigator(this)
        bindings.rvContacts.adapter = adapter

        viewModel.fetchFromDbClick()

        viewModel.allHistoryList.observe(
            this
        ) {
            viewModel.observableArrayList.addAll(it)
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this@HistoryActivity, CurrencyChangerDashboard::class.java)
        startActivity(intent)
        finish()
    }
}