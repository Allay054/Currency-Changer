package com.allaykhalil.apicallingwithcoroutinesandhilt.customSpinner

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.allaykhalil.apicallingwithcoroutinesandhilt.customSpinner.AdapterSpinner.AdapterSpinnerViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.allaykhalil.apicallingwithcoroutinesandhilt.R
import android.widget.TextView
import java.util.ArrayList

class AdapterSpinner(var context: Context, var spinnerDtos: ArrayList<CustomSpinnerModel>) :
    RecyclerView.Adapter<AdapterSpinnerViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): AdapterSpinnerViewHolder {
        val v: View =
            LayoutInflater.from(context).inflate(R.layout.custom_spin_view, viewGroup, false)
        return AdapterSpinnerViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdapterSpinnerViewHolder, i: Int) {
        val spinData = spinnerDtos[i].CountryName
        holder.spinView.text = spinData
    }

    override fun getItemCount(): Int {
        return spinnerDtos.size
    }

    class AdapterSpinnerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var spinView: TextView
        var idView: TextView

        init {
            spinView = itemView.findViewById(R.id.spinView)
            idView = itemView.findViewById(R.id.idView)
        }
    }
}