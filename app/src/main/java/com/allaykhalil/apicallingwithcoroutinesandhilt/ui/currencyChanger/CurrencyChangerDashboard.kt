package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.currencyChanger

import android.content.Intent
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.allaykhalil.apicallingwithcoroutinesandhilt.BR
import com.allaykhalil.apicallingwithcoroutinesandhilt.R
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseActivity
import com.allaykhalil.apicallingwithcoroutinesandhilt.customSpinner.CustomSpinnerModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.customSpinner.DialogSpinner
import com.allaykhalil.apicallingwithcoroutinesandhilt.databinding.ActivityCurrencyDashboardBinding
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.customModels.MyCustomCurrencySymbols
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.currencyChanger.viewModel.CurrencyDashboardViewModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.dashboard.DashBoard
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.historicalData.HistoryActivity
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class CurrencyChangerDashboard :
    BaseActivity<CurrencyDashboardViewModel, ActivityCurrencyDashboardBinding>(R.layout.activity_currency_dashboard),
    CurrencyChangerDashboardNavigator {


    private val allSymbolsList = ArrayList<CustomSpinnerModel>()
    override val viewModel: CurrencyDashboardViewModel by viewModels()

    companion object {
        lateinit var selectedItemA: CustomSpinnerModel
        lateinit var selectedItemB: CustomSpinnerModel
    }

    override fun getBindingVariable() = BR.viewModel

    private var selectedCountryA: String? = null

    private var selectedCountryB: String? = null

    private var amountNeedToBeConverted: String = "0"

    private var showIn1stEditText: Boolean = false

    // private var requestSended: Boolean = false

    override fun initUi() {
        viewModel.setNavigator(this)

        viewModel.allCurrencySymbols.observe(
            this
        ) {

            viewModel.myLiveData = it.allSymbols


            if (viewModel.observableArrayList.size > 0) {
                viewModel.observableArrayList.clear()
            }
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "AED",
                    it.allSymbols!!.AED.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "AFN",
                    it.allSymbols.AFN.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "ALL",
                    it.allSymbols.ALL.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "AMD",
                    it.allSymbols.AMD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "ANG",
                    it.allSymbols.ANG.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "AOA",
                    it.allSymbols.AOA.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "ARS",
                    it.allSymbols.ARS.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "AUD",
                    it.allSymbols.AUD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "AWG",
                    it.allSymbols.AWG.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "AZN",
                    it.allSymbols.AZN.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BAM",
                    it.allSymbols.BAM.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BBD",
                    it.allSymbols.BBD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BDT",
                    it.allSymbols.BDT.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BGN",
                    it.allSymbols.BGN.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BHD",
                    it.allSymbols.BHD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BIF",
                    it.allSymbols.BIF.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BMD",
                    it.allSymbols.BMD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BND",
                    it.allSymbols.BND.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BOB",
                    it.allSymbols.BOB.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BRL",
                    it.allSymbols.BRL.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BSD",
                    it.allSymbols.BSD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BTC",
                    it.allSymbols.BTC.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BTN",
                    it.allSymbols.BTN.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BWP",
                    it.allSymbols.BWP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "CHF",
                    it.allSymbols.CHF.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BYN",
                    it.allSymbols.BYN.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BYR",
                    it.allSymbols.BYR.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "CAD",
                    it.allSymbols.CAD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "BZD",
                    it.allSymbols.BZD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "CDF",
                    it.allSymbols.CDF.toString()
                )
            )
            /*.................................................*/
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "CHF",
                    it.allSymbols.CHF.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "CDF",
                    it.allSymbols.CDF.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "CLF",
                    it.allSymbols.CLF.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "CLP",
                    it.allSymbols.CLP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "CNY",
                    it.allSymbols.CNY.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "COP",
                    it.allSymbols.COP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "CRC",
                    it.allSymbols.CRC.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "CUC",
                    it.allSymbols.CUC.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "CUP",
                    it.allSymbols.CUP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "CVE",
                    it.allSymbols.CVE.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "CZK",
                    it.allSymbols.CZK.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "DJF",
                    it.allSymbols.DJF.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "DKK",
                    it.allSymbols.DKK.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "DOP",
                    it.allSymbols.DOP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "DZD",
                    it.allSymbols.DZD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "EGP",
                    it.allSymbols.EGP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "ERN",
                    it.allSymbols.ERN.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "ETB",
                    it.allSymbols.ETB.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "EUR",
                    it.allSymbols.EUR.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "FJD",
                    it.allSymbols.FJD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "FKP",
                    it.allSymbols.FKP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "GBP",
                    it.allSymbols.GBP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "GEL",
                    it.allSymbols.GEL.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "GGP",
                    it.allSymbols.GGP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "GHS",
                    it.allSymbols.GHS.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "GIP",
                    it.allSymbols.GIP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "GMD",
                    it.allSymbols.GMD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "GNF",
                    it.allSymbols.GNF.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "GTQ",
                    it.allSymbols.GTQ.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "GYD",
                    it.allSymbols.GYD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "HKD",
                    it.allSymbols.HKD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "HNL",
                    it.allSymbols.HNL.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "HRK",
                    it.allSymbols.HRK.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "HTG",
                    it.allSymbols.HTG.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "HUF",
                    it.allSymbols.HUF.toString()
                )
            )
///////////////////////////////////////////////////////////

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "IDR",
                    it.allSymbols.IDR.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "ILS",
                    it.allSymbols.ILS.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "IMP",
                    it.allSymbols.IMP.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "INR",
                    it.allSymbols.INR.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "IQD",
                    it.allSymbols.IQD.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "IRR",
                    it.allSymbols.IRR.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "JEP",
                    it.allSymbols.JEP.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "JMD",
                    it.allSymbols.JMD.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "JOD",
                    it.allSymbols.JOD.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "JPY",
                    it.allSymbols.JPY.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "KES",
                    it.allSymbols.KES.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "KGS",
                    it.allSymbols.KGS.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "KHR",
                    it.allSymbols.KHR.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "KMF",
                    it.allSymbols.KMF.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "KPW",
                    it.allSymbols.KPW.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "KRW",
                    it.allSymbols.KRW.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "KWD",
                    it.allSymbols.KWD.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "KYD",
                    it.allSymbols.KYD.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "KZT",
                    it.allSymbols.KZT.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "LAK",
                    it.allSymbols.LAK.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "LBP",
                    it.allSymbols.LBP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "LKR",
                    it.allSymbols.LKR.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "LRD",
                    it.allSymbols.LRD.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "LSL",
                    it.allSymbols.LSL.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "LTL",
                    it.allSymbols.LTL.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "LVL",
                    it.allSymbols.LVL.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "LYD",
                    it.allSymbols.LYD.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "MDL",
                    it.allSymbols.MAD.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "MDL",
                    it.allSymbols.MDL.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "MGA",
                    it.allSymbols.MGA.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "MKD",
                    it.allSymbols.MKD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "MMK",
                    it.allSymbols.MMK.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "MNT",
                    it.allSymbols.MNT.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "MOP",
                    it.allSymbols.MOP.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "MRO",
                    it.allSymbols.MRO.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "MUR",
                    it.allSymbols.MUR.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "MVR",
                    it.allSymbols.MVR.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "MWK",
                    it.allSymbols.MWK.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "MXN",
                    it.allSymbols.MXN.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "MXN",
                    it.allSymbols.MXN.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "MZN",
                    it.allSymbols.MZN.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "NAD",
                    it.allSymbols.NAD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "NGN",
                    it.allSymbols.NGN.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "NOK",
                    it.allSymbols.NOK.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "NIO",
                    it.allSymbols.NIO.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "NPR",
                    it.allSymbols.NPR.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "OMR",
                    it.allSymbols.OMR.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "NZD",
                    it.allSymbols.NZD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "PEN",
                    it.allSymbols.PEN.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "PAB",
                    it.allSymbols.PAB.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "PGK",
                    it.allSymbols.PGK.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "PHP",
                    it.allSymbols.PHP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "PKR",
                    it.allSymbols.PKR.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "PLN",
                    it.allSymbols.PLN.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "PYG",
                    it.allSymbols.PYG.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "QAR",
                    it.allSymbols.QAR.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "RON",
                    it.allSymbols.RON.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "RSD",
                    it.allSymbols.RSD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "RUB",
                    it.allSymbols.RUB.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "RWF",
                    it.allSymbols.RWF.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "SAR",
                    it.allSymbols.SAR.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "SBD",
                    it.allSymbols.SBD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "SCR",
                    it.allSymbols.SCR.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "SDG",
                    it.allSymbols.SDG.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "SEK",
                    it.allSymbols.SEK.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "SGD",
                    it.allSymbols.SGD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "SHP",
                    it.allSymbols.SHP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "SOS",
                    it.allSymbols.SOS.toString()
                )
            )

/////////////////////////////////////
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "SLL",
                    it.allSymbols.SLL.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "SRD",
                    it.allSymbols.SRD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "STD",
                    it.allSymbols.STD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "SVC",
                    it.allSymbols.SVC.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "SYP",
                    it.allSymbols.SYP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "SZL",
                    it.allSymbols.SZL.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "THB",
                    it.allSymbols.THB.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "TJS",
                    it.allSymbols.TJS.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "TMT",
                    it.allSymbols.TMT.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "TND",
                    it.allSymbols.TND.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "TOP",
                    it.allSymbols.TOP.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "TRY",
                    it.allSymbols.TRY.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "TTD",
                    it.allSymbols.TTD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "TWD",
                    it.allSymbols.TWD.toString()
                )
            )


///////////////////////////

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "TZS",
                    it.allSymbols.TZS.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "UAH",
                    it.allSymbols.UAH.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "UGX",
                    it.allSymbols.UGX.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "USD",
                    it.allSymbols.USD.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "UYU",
                    it.allSymbols.UYU.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "UZS",
                    it.allSymbols.UZS.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "VEF",
                    it.allSymbols.VEF.toString()
                )
            )
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "VES",
                    it.allSymbols.VES.toString()
                )
            )

////////////////////////////////////
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "VND",
                    it.allSymbols.VND.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "VUV",
                    it.allSymbols.VUV.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "WST",
                    it.allSymbols.WST.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "XAF",
                    it.allSymbols.XAF.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "XAG",
                    it.allSymbols.XAG.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "XAU",
                    it.allSymbols.XAU.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "XCD",
                    it.allSymbols.XCD.toString()
                )
            )

            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "XDR",
                    it.allSymbols.XDR.toString()
                )
            )
/////////////////////////////
            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "XOF",
                    it.allSymbols.XOF.toString()
                )
            )


            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "XPF",
                    it.allSymbols.XPF.toString()
                )
            )




            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "YER",
                    it.allSymbols.YER.toString()
                )
            )



            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "ZAR",
                    it.allSymbols.ZAR.toString()
                )
            )




            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "ZMK",
                    it.allSymbols.ZMK.toString()
                )
            )







            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "ZMW",
                    it.allSymbols.ZMW.toString()
                )
            )



            viewModel.observableArrayList.add(
                MyCustomCurrencySymbols(
                    "ZWL",
                    it.allSymbols.ZWL.toString()
                )
            )




            if (allSymbolsList.size > 0) {
                allSymbolsList.clear()
            }
            for (item in viewModel.observableArrayList) {
                allSymbolsList.add(CustomSpinnerModel(item.symbol, item.countryName.toString()))

            }

            selectedItemA = allSymbolsList[0]
            selectedItemB = allSymbolsList[allSymbolsList.size - 1]

            bindings.etSelectedCountryA.text = selectedItemA.CountryName
            bindings.etSelectedCountryB.text = selectedItemB.CountryName
        }

        viewModel.convertedResult.observe(
            this
        ) {
            amountNeedToBeConverted = "0"
            if (showIn1stEditText) {
                bindings.etCurrencyValueA.text = Editable.Factory.getInstance()
                    .newEditable(viewModel.convertedResult.value!!.result.toString())
                showIn1stEditText = false
            } else {
                bindings.etCurrencyValueB.text = Editable.Factory.getInstance()
                    .newEditable(viewModel.convertedResult.value!!.result.toString())

            }
        }

          viewModel.fetchAllCurrencySymbols()

        bindings.apply {
            lifecycleOwner = this@CurrencyChangerDashboard
            viewModel = this@CurrencyChangerDashboard.viewModel

            showDropDownA = View.OnClickListener {
                if (allSymbolsList.size > 0) {
                    selectedItemA = allSymbolsList[0]
                    setupSymbolSpinnerA(allSymbolsList)
                }
            }

            showDropDownB = View.OnClickListener {
                if (allSymbolsList.size > 0) {
                    selectedItemB = allSymbolsList[allSymbolsList.size - 1]

                    setupSymbolSpinnerB(allSymbolsList)
                }
            }
            /*    historyDetail = View.OnClickListener {

                }*/

            historyDetail = View.OnClickListener {
                val intent = Intent(this@CurrencyChangerDashboard, HistoryActivity::class.java)
                startActivity(intent)
                finish()
            }

        }

        /* bindings.etCurrencyValueA.afterTextChangedDelayed {
             if (bindings.etCurrencyValueA.text.isNotEmpty()) {
                 amountNeedToBeConverted = bindings.etCurrencyValueA.text.toString()
                 Log.d("==>", "Amount : $amountNeedToBeConverted")

                 selectedCountryA = bindings.etSelectedCountryA.text.toString()

                 selectedCountryB = bindings.etSelectedCountryB.text.toString()

                 if (selectedCountryA.toString() == null || selectedCountryA.toString().isEmpty()) {
                     Toast.makeText(
                         this@CurrencyChangerDashboard,
                         "Please select From Value",
                         Toast.LENGTH_SHORT
                     ).show()
                 } else if (selectedCountryB.toString() == null || selectedCountryB.toString()
                         .isEmpty()
                 ) {
                     Toast.makeText(
                         this@CurrencyChangerDashboard,
                         "Please select To Value",
                         Toast.LENGTH_SHORT
                     ).show()
                 } else {

                     val sdf = SimpleDateFormat("YYYY-MM-dd")
                     val currentDate = sdf.format(Date())
                     Log.d("==>", "Current Date: $currentDate")
                     Log.d("==>", "Country A: " + selectedItemA.currencySymbol)
                     Log.d("==>", "Country B: " + selectedItemB.currencySymbol)
                     Log.d("==>", "Amount need to be converted: $amountNeedToBeConverted")
                     showIn1stEditText = false
                     if (amountNeedToBeConverted != "0") {

                         viewModel.amountNeedToBeConverted.value = amountNeedToBeConverted
                         viewModel.toValue.value = selectedItemB.currencySymbol
                         viewModel.fromValue.value = selectedItemA.currencySymbol
                         if(!requestSended){
                             requestSended = true
                             viewModel.hitConvertCurrencyApi()
                         }


                         Toast.makeText(
                             this@CurrencyChangerDashboard,
                             "Hit API to convert the amount",
                             Toast.LENGTH_SHORT
                         ).show()

                     } else {
                         Toast.makeText(
                             this@CurrencyChangerDashboard,
                             "Amount should be greater then 0",
                             Toast.LENGTH_SHORT
                         ).show()
                     }

                 }

             } else {
                 Toast.makeText(
                     this@CurrencyChangerDashboard,
                     "Amount should be greater then 0",
                     Toast.LENGTH_SHORT
                 ).show()
             }


         }*/

        bindings.etCurrencyValueA.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (bindings.etCurrencyValueA.text.isNotEmpty()) {
                    amountNeedToBeConverted = bindings.etCurrencyValueA.text.toString()
                    Log.d("==>", "Amount : $amountNeedToBeConverted")

                    selectedCountryA = bindings.etSelectedCountryA.text.toString()

                    selectedCountryB = bindings.etSelectedCountryB.text.toString()

                    if (selectedCountryA.toString() == null || selectedCountryA.toString()
                            .isEmpty()
                    ) {
                        Toast.makeText(
                            this@CurrencyChangerDashboard,
                            "Please select From Value",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (selectedCountryB.toString() == null || selectedCountryB.toString()
                            .isEmpty()
                    ) {
                        Toast.makeText(
                            this@CurrencyChangerDashboard,
                            "Please select To Value",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {

                        val sdf = SimpleDateFormat("YYYY-MM-dd")
                        val currentDate = sdf.format(Date())
                        Log.d("==>", "Current Date: $currentDate")
                        Log.d("==>", "Country A: " + selectedItemA.currencySymbol)
                        Log.d("==>", "Country B: " + selectedItemB.currencySymbol)
                        Log.d("==>", "Amount need to be converted: $amountNeedToBeConverted")
                        showIn1stEditText = false
                        if (amountNeedToBeConverted != "0") {

                            viewModel.amountNeedToBeConverted.value = amountNeedToBeConverted
                            viewModel.toValue.value = selectedItemB.currencySymbol
                            viewModel.fromValue.value = selectedItemA.currencySymbol
                            viewModel.hitConvertCurrencyApi()

                        } else {
                            Toast.makeText(
                                this@CurrencyChangerDashboard,
                                "Amount should be greater then 0",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }

                } else {
                    Toast.makeText(
                        this@CurrencyChangerDashboard,
                        "Amount should be greater then 0",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            true
        }

        bindings.etCurrencyValueB.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (bindings.etCurrencyValueB.text.isNullOrEmpty()) {
                    Toast.makeText(
                        this@CurrencyChangerDashboard,
                        "Please enter amount need to be converted",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    amountNeedToBeConverted = bindings.etCurrencyValueB.text.toString()
                    selectedCountryA = bindings.etSelectedCountryB.text.toString()

                    selectedCountryB = bindings.etSelectedCountryA.text.toString()

                    if (selectedCountryA.toString() == null || selectedCountryA.toString()
                            .isEmpty()
                    ) {
                        Toast.makeText(
                            this@CurrencyChangerDashboard,
                            "Please select From Value",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (selectedCountryB.toString() == null || selectedCountryB.toString()
                            .isEmpty()
                    ) {
                        Toast.makeText(
                            this@CurrencyChangerDashboard,
                            "Please select To Value",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val sdf = SimpleDateFormat("YYYY-MM-DD")
                        val currentDate = sdf.format(Date())
                        Log.d("==>", "Current Date: $currentDate")

                        Log.d("==>", "Country A: " + selectedItemB.currencySymbol)
                        Log.d("==>", "Country B: " + selectedItemA.currencySymbol)
                        Log.d("==>", "Amount need to be converted: $amountNeedToBeConverted")

                        showIn1stEditText = true

                        if (amountNeedToBeConverted != "0") {

                            viewModel.amountNeedToBeConverted.value = amountNeedToBeConverted
                            viewModel.toValue.value = selectedItemA.currencySymbol
                            viewModel.fromValue.value = selectedItemB.currencySymbol
                            viewModel.hitConvertCurrencyApi()

                        } else {
                            Toast.makeText(
                                this@CurrencyChangerDashboard,
                                "Amount should be greater then 0",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                }
            }
            true
        }

        /*bindings.etCurrencyValueB.afterTextChangedDelayed {

            if (bindings.etCurrencyValueB.text.isNullOrEmpty()) {
                Toast.makeText(
                    this@CurrencyChangerDashboard,
                    "Please enter amount need to be converted",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                amountNeedToBeConverted = bindings.etCurrencyValueB.text.toString()
                selectedCountryA = bindings.etSelectedCountryB.text.toString()

                selectedCountryB = bindings.etSelectedCountryA.text.toString()

                if (selectedCountryA.toString() == null || selectedCountryA.toString().isEmpty()) {
                    Toast.makeText(
                        this@CurrencyChangerDashboard,
                        "Please select From Value",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (selectedCountryB.toString() == null || selectedCountryB.toString()
                        .isEmpty()
                ) {
                    Toast.makeText(
                        this@CurrencyChangerDashboard,
                        "Please select To Value",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val sdf = SimpleDateFormat("YYYY-MM-DD")
                    val currentDate = sdf.format(Date())
                    Log.d("==>", "Current Date: $currentDate")

                    Log.d("==>", "Country A: " + selectedItemB.currencySymbol)
                    Log.d("==>", "Country B: " + selectedItemA.currencySymbol)
                    Log.d("==>", "Amount need to be converted: $amountNeedToBeConverted")




                    showIn1stEditText = true

                    if (amountNeedToBeConverted != "0") {
                        Toast.makeText(
                            this@CurrencyChangerDashboard,
                            "Hit API to convert the amount",
                            Toast.LENGTH_SHORT
                        ).show()
                        viewModel.amountNeedToBeConverted.value = amountNeedToBeConverted
                        viewModel.toValue.value = selectedItemA.currencySymbol
                        viewModel.fromValue.value = selectedItemB.currencySymbol
                        if(!requestSended){
                            requestSended = true
                            viewModel.hitConvertCurrencyApi()
                        }
                        //   viewModel.hitConvertCurrencyApi()
                    } else {
                        Toast.makeText(
                            this@CurrencyChangerDashboard,
                            "Amount should be greater then 0",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
            }
        }*/

    }

    override fun onBackPressed() {
        val intent = Intent(this@CurrencyChangerDashboard, DashBoard::class.java)
        startActivity(intent)
        finish()
    }

    private fun setupSymbolSpinnerA(listDropDown: ArrayList<CustomSpinnerModel>) {

        DialogSpinner.show(
            this@CurrencyChangerDashboard,
            "Select Option",
            listDropDown,
            bindings.etSelectedCountryA,
            true
        )
    }

    private fun setupSymbolSpinnerB(listDropDown: ArrayList<CustomSpinnerModel>) {

        DialogSpinner.show(
            this@CurrencyChangerDashboard,
            "Select Option",
            listDropDown,
            bindings.etSelectedCountryB,
            false
        )
    }

    private fun TextView.afterTextChangedDelayed(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            var timer: CountDownTimer? = null

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(editable: Editable?) {
                timer?.cancel()
                if (editable!!.isEmpty()) {
                    amountNeedToBeConverted = "0"
                }
                Log.d("==>", "length:" + editable.length.toString())
                timer = object : CountDownTimer(1000, 1500) {
                    override fun onTick(millisUntilFinished: Long) {}
                    override fun onFinish() {
                        afterTextChanged.invoke(editable.toString())
                    }
                }.start()
            }
        })
    }
}