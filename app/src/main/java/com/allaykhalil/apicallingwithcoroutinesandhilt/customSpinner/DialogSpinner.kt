package com.allaykhalil.apicallingwithcoroutinesandhilt.customSpinner

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.widget.TextView
import com.allaykhalil.apicallingwithcoroutinesandhilt.R
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.currencyChanger.CurrencyChangerDashboard
import java.util.ArrayList

object DialogSpinner {
    var spinnerDtos: ArrayList<CustomSpinnerModel>? = null

    var adapterSpinner: AdapterSpinner? = null
    fun show(
        context: Context?,
        header: String?,
        arrayList: ArrayList<CustomSpinnerModel>,
        whereYouCanSet: TextView,
        valueA: Boolean
    ) {
        val dialog1 = Dialog(context!!)
        dialog1.setCanceledOnTouchOutside(false)
        spinnerDtos = ArrayList()
        spinnerDtos = arrayList
        dialog1.setContentView(R.layout.spinner_view)
        dialog1.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog1.window!!.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val button = dialog1.findViewById<ImageView>(R.id.iv_mark)
        button.setOnClickListener { dialog1.dismiss() }
        val spinnerRec = dialog1.findViewById<RecyclerView>(R.id.spinnerRecy)
        val txtHead = dialog1.findViewById<TextView>(R.id.txtHead)
        txtHead.text = header
        adapterSpinner = AdapterSpinner(context, spinnerDtos!!)
        spinnerRec.adapter = adapterSpinner
        val mLayoutManager = LinearLayoutManager(context)
        spinnerRec.layoutManager = mLayoutManager
        spinnerRec.addOnItemTouchListener(
            RecyclerItemClickListener(
                context,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {
                        val spinnerDto = spinnerDtos!![position].CountryName
                        whereYouCanSet.text = spinnerDto
                        if (valueA) {
                            CurrencyChangerDashboard.selectedItemA = spinnerDtos!![position]
                        } else {
                            CurrencyChangerDashboard.selectedItemB = spinnerDtos!![position]
                        }
                        dialog1.dismiss()
                    }
                })
        )
        spinnerRec.setHasFixedSize(true)
        dialog1.show()
    }
}