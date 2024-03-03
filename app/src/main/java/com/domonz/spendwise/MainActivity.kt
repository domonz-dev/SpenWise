package com.domonz.spendwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.domonz.careercraft.Adapters.AdapterBottomNav
import com.domonz.spendwise.Adapters.AdapterOffers
import com.domonz.spendwise.Adapters.AdapterPopularMeals
import com.domonz.spendwise.Adapters.AdapterSortOptions
import com.domonz.spendwise.Adapters.AdapterSubscriptions
import com.domonz.spendwise.Fragments.QuickGrabFragment
import com.domonz.spendwise.Interfaces.ItemClickListener
import com.domonz.spendwise.Models.ModelPopularMeals
import com.domonz.spendwise.Models.ModelSubscriptions
import com.domonz.spendwise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    var currentNavigation = 0
    var adapterBottomNav:AdapterBottomNav? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        instance = this
        setContentView(binding.root)
        updateData()
    }

    fun updateData(){

        binding.apply {
            setNavigation()
            recBottomNav.layoutManager = GridLayoutManager(this@MainActivity, 4)
            adapterBottomNav = AdapterBottomNav(this@MainActivity, object:ItemClickListener{
                override fun onClick(position: Int, data: Any?) {
                    if (position == 2 && currentNavigation != 2) {
                        if(currentNavigation == 1){
                            findNavController(binding.fragmentContainerView.id).navigate(R.id.action_subscriptionFragment_to_quickGrabFragment)
                        }else {
                            findNavController(binding.fragmentContainerView.id).navigate(R.id.action_homeFragment_to_quickGrabFragment)
                        }
                    }else{
                        if(position == 0){
                            if(currentNavigation != 0){
                                findNavController(binding.fragmentContainerView.id).popBackStack()
                            }
                        }
                    }
                }
            })
            recBottomNav.adapter = adapterBottomNav
        }

    }

    fun setNavigation(){
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        val inflater = navController.navInflater
        val graph = inflater.inflate(R.navigation.home_nav)
        navHostFragment.navController.graph = graph
    }


    companion object{
        var instance:MainActivity? = null
            private set
    }




}