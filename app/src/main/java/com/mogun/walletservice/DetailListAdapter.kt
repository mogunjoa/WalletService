package com.mogun.walletservice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mogun.walletservice.databinding.ItemDetailBinding
import com.mogun.walletservice.model.DetailItem

class DetailListAdapter: ListAdapter<DetailItem, DetailViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailViewHolder {
        return DetailViewHolder(
            ItemDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: DetailViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    class DiffCallback: DiffUtil.ItemCallback<DetailItem>() {
        override fun areItemsTheSame(
            oldItem: DetailItem,
            newItem: DetailItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DetailItem,
            newItem: DetailItem
        ): Boolean {
            return oldItem == newItem
        }

    }

}