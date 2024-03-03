package com.domonz.spendwise.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.domonz.spendwise.Models.ModelCardStack
import com.domonz.spendwise.Models.ModelSubscriptions
import com.domonz.spendwise.R
import com.domonz.spendwise.databinding.ItemOfferCardBinding
import com.domonz.spendwise.databinding.ItemQuickGrabCardBinding
import com.domonz.spendwise.databinding.ItemSortOptionBinding
import com.domonz.spendwise.databinding.ItemSubscriptionBinding

class AdapterCardStack(var context:Context, var _data:ArrayList<ModelCardStack>):RecyclerView.Adapter<AdapterCardStack.ViewHolder>() {
    class ViewHolder(var binding:ItemQuickGrabCardBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemQuickGrabCardBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {

            val md = _data[position]

            title.text = md.title
            includes.text = md.description
            rating.text = md.ratings
            ratingCount.text = md.ratingCount
            image.setImageResource(md.image)

        }
    }

    override fun getItemCount(): Int {

        return _data.size

    }
}