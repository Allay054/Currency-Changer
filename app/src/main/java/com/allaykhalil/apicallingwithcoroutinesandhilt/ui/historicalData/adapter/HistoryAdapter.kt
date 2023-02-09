package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.historicalData.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseViewHolder
import com.allaykhalil.apicallingwithcoroutinesandhilt.databinding.ItemHistoryBinding
import com.allaykhalil.apicallingwithcoroutinesandhilt.interfaces.AdapterUpdateListener
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ConversionHistoryModel
import javax.inject.Inject

class HistoryAdapter @Inject constructor() :
    RecyclerView.Adapter<HistoryAdapter.ItemViewHolder>(),
    AdapterUpdateListener<ConversionHistoryModel> {
    val contactList = ArrayList<ConversionHistoryModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun clearItems() {
        contactList.clear()
        notifyDataSetChanged()
    }

    override fun addItems(items: List<ConversionHistoryModel>, isLoadMore: Boolean) {
        if (!isLoadMore) {
            clearItems()
            contactList.addAll(items as Collection<ConversionHistoryModel>)
            notifyDataSetChanged()
        }
    }

    inner class ItemViewHolder(val binding: ItemHistoryBinding) : BaseViewHolder(binding.root) {
        override fun onBind(position: Int) {
            binding.viewModel = HistoryItemViewModel(contactList[position])
            binding.executePendingBindings()
        }
    }
}