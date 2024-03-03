package com.domonz.spendwise.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.domonz.spendwise.Adapters.AdapterCafeOfFoods
import com.domonz.spendwise.Adapters.AdapterSortOptions
import com.domonz.spendwise.Interfaces.ItemClickListener
import com.domonz.spendwise.MainActivity
import com.domonz.spendwise.R
import com.domonz.spendwise.databinding.FragmentSubscriptionViewBinding

class SubscriptionViewFragment : Fragment() {

    var _binding:FragmentSubscriptionViewBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSubscriptionViewBinding.inflate(inflater, container, false)
        instance = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            MainActivity.instance?.currentNavigation = 1

            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            recSortOptions.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            recSortOptions.adapter = AdapterSortOptions(requireContext(), ArrayList<String>().apply {
                add("Sort by")
                add("Veg")
                add("Non Veg")
                add("4+ Rating")
                add("Under 200")
                add("Under 400")
            })

            recCafeWithFoods.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            recCafeWithFoods.adapter = AdapterCafeOfFoods(requireContext(), ArrayList<String>().apply {
                add("")
                add("")
                add("")
            }, object:ItemClickListener{
                override fun onClick(position: Int, data: Any?) {
                    findNavController().navigate(R.id.action_subscriptionFragment_to_quickGrabFragment)
                }
            })

        }

    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        MainActivity.instance?.currentNavigation = 1
        MainActivity.instance?.adapterBottomNav?.selected = 0
        MainActivity.instance?.adapterBottomNav?.notifyDataSetChanged()

    }

    companion object {

        var instance:SubscriptionViewFragment? = null
            private set

    }
}