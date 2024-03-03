package com.domonz.careercraft.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.domonz.spendwise.Interfaces.ItemClickListener
import com.domonz.spendwise.R
import com.domonz.spendwise.databinding.ItemBottomNavBinding

class AdapterBottomNav(var context: Context, var callback:ItemClickListener?): RecyclerView.Adapter<AdapterBottomNav.ViewHolder>(){

    var selected:Int = 0

    class ViewHolder(var binding: ItemBottomNavBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBottomNavBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {


            if(position == 0){
                icon.setImageResource(R.drawable.home_stroke)
                label.text = "Home"
            }else if(position == 1){
                icon.setImageResource(R.drawable.calender)
                label.text = "My Meals"
            }else if(position == 2){
                icon.setImageResource(R.drawable.cart)
                label.text = "Quick Grab"
            }else{
                icon.setImageResource(R.drawable.profile)
                label.text = "Profile"
            }

            if(position == selected){
                icon.setColorFilter(context.resources.getColor(R.color.ui))
                label.setTextColor(context.resources.getColor(R.color.ui))
            }else{
                icon.setColorFilter(context.resources.getColor(R.color.black))
                label.setTextColor(context.resources.getColor(R.color.black))
            }

            holder.itemView.setOnClickListener {
                selected = position
                notifyDataSetChanged()
                callback?.onClick(position, label.text)
            }

        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}
