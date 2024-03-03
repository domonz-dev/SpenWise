package com.domonz.spendwise.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.domonz.spendwise.Models.ModelPopularMeals
import com.domonz.spendwise.Models.ModelSubscriptions
import com.domonz.spendwise.R
import com.domonz.spendwise.databinding.ItemPopularMealsBinding
import com.domonz.spendwise.databinding.ItemSortOptionBinding
import com.domonz.spendwise.databinding.ItemSubscriptionBinding

class AdapterPopularMeals(var context:Context, var _data:ArrayList<ModelPopularMeals>):RecyclerView.Adapter<AdapterPopularMeals.ViewHolder>() {
    class ViewHolder(var binding:ItemPopularMealsBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPopularMealsBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val md = _data[position]
            image.setImageResource(md.image)
            title.text = md.title
        }
    }

    override fun getItemCount(): Int {

        return _data.size

    }
}