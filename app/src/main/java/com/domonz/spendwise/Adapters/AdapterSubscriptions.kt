package com.domonz.spendwise.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.domonz.spendwise.Interfaces.ItemClickListener
import com.domonz.spendwise.Models.ModelSubscriptions
import com.domonz.spendwise.R
import com.domonz.spendwise.databinding.ItemSortOptionBinding
import com.domonz.spendwise.databinding.ItemSubscriptionBinding

class AdapterSubscriptions(var context:Context, var _data:ArrayList<ModelSubscriptions>, var callback:ItemClickListener?):RecyclerView.Adapter<AdapterSubscriptions.ViewHolder>() {
    class ViewHolder(var binding:ItemSubscriptionBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSubscriptionBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val md = _data[position]
            image.setImageResource(md.image)
            title.text = md.title

            holder.itemView.setOnClickListener {
                callback?.onClick(position, md)
            }

        }
    }

    override fun getItemCount(): Int {

        return _data.size

    }
}