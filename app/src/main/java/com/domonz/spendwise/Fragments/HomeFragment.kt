package com.domonz.spendwise.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.domonz.spendwise.Adapters.AdapterOffers
import com.domonz.spendwise.Adapters.AdapterPopularMeals
import com.domonz.spendwise.Adapters.AdapterSortOptions
import com.domonz.spendwise.Adapters.AdapterSubscriptions
import com.domonz.spendwise.Interfaces.ItemClickListener
import com.domonz.spendwise.MainActivity
import com.domonz.spendwise.Models.ModelPopularMeals
import com.domonz.spendwise.Models.ModelSubscriptions
import com.domonz.spendwise.R
import com.domonz.spendwise.databinding.FragmentHomeBinding
import com.domonz.spendwise.databinding.FragmentSubscriptionViewBinding


class HomeFragment : Fragment() {

    var _binding:FragmentHomeBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        instance = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            MainActivity.instance?.currentNavigation = 0
            recSortOptions.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            recSortOptions.adapter = AdapterSortOptions(requireContext(), ArrayList<String>().apply {
                add("Sort by")
                add("Veg")
                add("Non Veg")
                add("4+ Rating")
                add("Under 200")
                add("Under 400")
            })

            recSubscriptions.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            recSubscriptions.adapter = AdapterSubscriptions(requireContext(), ArrayList<ModelSubscriptions>().apply {
                add(ModelSubscriptions(R.drawable.breakfast_placeholder, "Breakfast"))
                add(ModelSubscriptions(R.drawable.lunch_placeholder, "Lunch"))
                add(ModelSubscriptions(R.drawable.dinner_placeholder, "Dinner"))
            }, object:ItemClickListener{
                override fun onClick(position: Int, data: Any?) {
                    findNavController().navigate(R.id.action_homeFragment_to_subscriptionFragment)
                }
            })


            recPopularMeals.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            recPopularMeals.adapter = AdapterPopularMeals(requireContext(), ArrayList<ModelPopularMeals>().apply {
                add(ModelPopularMeals(R.drawable.pop_meals_1, "Veg Thali"))
                add(ModelPopularMeals(R.drawable.pop_meals_2, "Chicken Thali"))
                add(ModelPopularMeals(R.drawable.pop_meals_3, "Pulao"))
                add(ModelPopularMeals(R.drawable.pop_meals_4, "Biryani"))
                add(ModelPopularMeals(R.drawable.pop_meals_5, "Premium Thali"))
            })

            recOffers.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            recOffers.adapter = AdapterOffers(requireContext(), ArrayList<String>().apply {
                add("")
                add("")
            })
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        MainActivity.instance?.currentNavigation = 0
        MainActivity.instance?.adapterBottomNav?.selected = 0
        MainActivity.instance?.adapterBottomNav?.notifyDataSetChanged()
    }

    companion object{
        var instance:HomeFragment? = null
            private set
    }

}