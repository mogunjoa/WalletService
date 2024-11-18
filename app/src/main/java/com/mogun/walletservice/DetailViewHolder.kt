package com.mogun.walletservice

import androidx.recyclerview.widget.RecyclerView
import com.mogun.walletservice.databinding.ItemDetailBinding
import com.mogun.walletservice.model.DetailItem

class DetailViewHolder(private val binding: ItemDetailBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: DetailItem) {
        binding.item = item
    }
}