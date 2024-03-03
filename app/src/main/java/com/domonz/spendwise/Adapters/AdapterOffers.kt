package com.domonz.spendwise.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.domonz.spendwise.Models.ModelSubscriptions
import com.domonz.spendwise.R
import com.domonz.spendwise.databinding.ItemOfferCardBinding
import com.domonz.spendwise.databinding.ItemSortOptionBinding
import com.domonz.spendwise.databinding.ItemSubscriptionBinding

class AdapterOffers(var context:Context, var _data:ArrayList<String>):RecyclerView.Adapter<AdapterOffers.ViewHolder>() {
    class ViewHolder(var binding:ItemOfferCardBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemOfferCardBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
        }
    }

    override fun getItemCount(): Int {

        return _data.size

    }
}