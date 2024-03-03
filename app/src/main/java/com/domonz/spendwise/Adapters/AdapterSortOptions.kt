package com.domonz.spendwise.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.domonz.spendwise.R
import com.domonz.spendwise.databinding.ItemSortOptionBinding

class AdapterSortOptions(var context:Context, var _data:ArrayList<String>):RecyclerView.Adapter<AdapterSortOptions.ViewHolder>() {
    class ViewHolder(var binding:ItemSortOptionBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSortOptionBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val label = root as TextView
            if(position == 0){
                label.text = _data[position]
            }else {
                label.setCompoundDrawables(null, null, null, null)
                label.text = _data[position]
            }
        }
    }

    override fun getItemCount(): Int {

        return _data.size

    }
}