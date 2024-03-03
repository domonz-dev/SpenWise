package com.domonz.spendwise.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.navigation.fragment.findNavController
import com.domonz.spendwise.Adapters.AdapterCardStack
import com.domonz.spendwise.MainActivity
import com.domonz.spendwise.Models.ModelCardStack
import com.domonz.spendwise.R
import com.domonz.spendwise.databinding.FragmentQuickGrabBinding
import com.domonz.spendwise.databinding.FragmentSubscriptionViewBinding
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.StackFrom


class QuickGrabFragment : Fragment() {


    var _binding: FragmentQuickGrabBinding? = null
    val binding get() = _binding!!
    var handler:Handler? = null
    var runnable:Runnable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentQuickGrabBinding.inflate(inflater, container, false)
        instance = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            MainActivity.instance?.currentNavigation = 2
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }


            runnable = Runnable {
                binding.layoutItemAddedToCart.visibility = View.GONE
            }

            val cardLayoutManager = CardStackLayoutManager(requireContext(), object:CardStackListener{
                override fun onCardDragging(direction: Direction?, ratio: Float) {

                }

                override fun onCardSwiped(direction: Direction?) {

                    if(direction == Direction.Right){
                        binding.layoutItemAddedToCart.visibility = View.VISIBLE
                        if(handler != null){
                            handler?.removeCallbacks(runnable!!)
                        }
                        handler = Handler()
                        handler?.postDelayed(runnable!!, 2000)
                    }

                }

                override fun onCardRewound() {
                }

                override fun onCardCanceled() {
                }

                override fun onCardAppeared(view: View?, position: Int) {
                }

                override fun onCardDisappeared(view: View?, position: Int) {
                }
            })
            cardLayoutManager.setOverlayInterpolator(LinearInterpolator())
            cardLayoutManager.setDirections(Direction.FREEDOM)
            cardLayoutManager.setTranslationInterval(8.0f)
            cardLayoutManager.setVisibleCount(2)
            cardLayoutManager.setStackFrom(StackFrom.Bottom)
            cardLayoutManager.setMaxDegree(0f)
            cardLayoutManager.setScaleInterval(0.95f)

            cardStackView.layoutManager = cardLayoutManager

            cardStackView.adapter = AdapterCardStack(requireContext(), ArrayList<ModelCardStack>().apply {

                add(ModelCardStack("Tawa Pulao", "Cooked with basmati rice", "₹99", "4.2", "(23)", R.drawable.lunch_placeholder))
                add(ModelCardStack("Tawa Pulao1", "Cooked with basmati rice", "₹99", "4.2", "(31)", R.drawable.breakfast_placeholder))
                add(ModelCardStack("Tawa Pulao2", "Cooked with basmati rice", "₹99", "4.2", "(2)", R.drawable.dinner_placeholder))
                add(ModelCardStack("Tawa Pulao3", "Cooked with basmati rice", "₹99", "4.2", "(56)", R.drawable.breakfast_placeholder))
                add(ModelCardStack("Tawa Pulao4", "Cooked with basmati rice", "₹99", "4.2", "(103)", R.drawable.lunch_placeholder))
                add(ModelCardStack("Tawa Pulao5", "Cooked with basmati rice", "₹99", "4.2", "(89)", R.drawable.dinner_placeholder))
                add(ModelCardStack("Tawa Pulao", "Cooked with basmati rice", "₹99", "4.2", "(23)", R.drawable.lunch_placeholder))
                add(ModelCardStack("Tawa Pulao1", "Cooked with basmati rice", "₹99", "4.2", "(31)", R.drawable.breakfast_placeholder))
                add(ModelCardStack("Tawa Pulao2", "Cooked with basmati rice", "₹99", "4.2", "(2)", R.drawable.dinner_placeholder))
                add(ModelCardStack("Tawa Pulao3", "Cooked with basmati rice", "₹99", "4.2", "(56)", R.drawable.breakfast_placeholder))
                add(ModelCardStack("Tawa Pulao4", "Cooked with basmati rice", "₹99", "4.2", "(103)", R.drawable.lunch_placeholder))
                add(ModelCardStack("Tawa Pulao5", "Cooked with basmati rice", "₹99", "4.2", "(89)", R.drawable.dinner_placeholder))
                add(ModelCardStack("Tawa Pulao", "Cooked with basmati rice", "₹99", "4.2", "(23)", R.drawable.lunch_placeholder))
                add(ModelCardStack("Tawa Pulao1", "Cooked with basmati rice", "₹99", "4.2", "(31)", R.drawable.breakfast_placeholder))
                add(ModelCardStack("Tawa Pulao2", "Cooked with basmati rice", "₹99", "4.2", "(2)", R.drawable.dinner_placeholder))
                add(ModelCardStack("Tawa Pulao3", "Cooked with basmati rice", "₹99", "4.2", "(56)", R.drawable.breakfast_placeholder))
                add(ModelCardStack("Tawa Pulao4", "Cooked with basmati rice", "₹99", "4.2", "(103)", R.drawable.lunch_placeholder))
                add(ModelCardStack("Tawa Pulao5", "Cooked with basmati rice", "₹99", "4.2", "(89)", R.drawable.dinner_placeholder))

            })


        }


    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        MainActivity.instance?.currentNavigation = 2
        MainActivity.instance?.adapterBottomNav?.selected = 2
        MainActivity.instance?.adapterBottomNav?.notifyDataSetChanged()

    }

    companion object {
        var instance:QuickGrabFragment? = null
            private set
    }
}