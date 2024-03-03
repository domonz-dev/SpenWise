package com.domonz.spendwise.Models

import android.widget.ArrayAdapter

data class ModelCafeFoodDetails(
    var title:String,
    var ratings:String,
    var deliveryTime:String,
    var distance:String,
    var startingPrice:String,
    var listOfAvailableFoods:ArrayList<ModelFoodDetails>
)

data class ModelFoodDetails(
    var title:String,
    var includes:String,
    var price:String,
    var ratings: String,
    var ratingCount:Int,
    var veg:Boolean,
    var image:String
)
