package com.domonz.spendwise.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.domonz.spendwise.Interfaces.ItemClickListener
import com.domonz.spendwise.Models.ModelSubscriptions
import com.domonz.spendwise.R
import com.domonz.spendwise.databinding.ItemCafeWithFoodBinding
import com.domonz.spendwise.databinding.ItemFoodDetailsBinding
import com.domonz.spendwise.databinding.ItemOfferCardBinding
import com.domonz.spendwise.databinding.ItemSortOptionBinding
import com.domonz.spendwise.databinding.ItemSubscriptionBinding

class AdapterCafeOfFoods(var context:Context, var _data:ArrayList<String>, var callback:ItemClickListener?):RecyclerView.Adapter<AdapterCafeOfFoods.ViewHolder>() {
    class ViewHolder(var binding:ItemCafeWithFoodBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCafeWithFoodBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            recFoodDetails.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recFoodDetails.adapter = AdapterFoodsDetails(context, ArrayList<String>().apply {
                add("")
                add("")
            }, position,callback)

            holder.itemView.setOnClickListener {
                callback?.onClick(position, "")
            }
        }
    }

    override fun getItemCount(): Int {

        return _data.size

    }
}

class AdapterFoodsDetails(var context:Context, var _data:ArrayList<String>, var position: Int,var callback:ItemClickListener?):RecyclerView.Adapter<AdapterFoodsDetails.ViewHolder>() {
    class ViewHolder(var binding:ItemFoodDetailsBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemFoodDetailsBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            holder.itemView.setOnClickListener {
                callback?.onClick(position, "")
            }
        }
    }

    override fun getItemCount(): Int {

        return _data.size

    }
}