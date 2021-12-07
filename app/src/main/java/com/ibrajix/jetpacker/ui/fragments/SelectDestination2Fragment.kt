/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.jetpacker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ibrajix.jetpacker.R
import com.ibrajix.jetpacker.databinding.FragmentSelectDestination2Binding
import com.ibrajix.jetpacker.ui.model.TripDetails
import com.ibrajix.jetpacker.utils.viewBinding

class SelectDestination2Fragment : Fragment() {

    private val binding by viewBinding(FragmentSelectDestination2Binding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_destination2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){

        //handle clicks
        handleClicks()
    }

    private fun handleClicks(){


        //on click back
        binding.icBack.setOnClickListener {
            findNavController().popBackStack()
        }

        val tripDetails1 = TripDetails(
            spaceCraft = requireContext().getString(R.string.falcon_9),
            station = requireContext().getString(R.string.abuja_to_moon),
            orbit = requireContext().getString(R.string.earth_earth),
            type = requireContext().getString(R.string.natural),
            fair_2 = requireContext().getString(R.string.royalty_landing),
            btc_2 = requireContext().getString(R.string.two_hundred_btc),
        )

        val tripDetails2 = TripDetails(
            spaceCraft = requireContext().getString(R.string.falcon_9),
            station = requireContext().getString(R.string.mars_to_space),
            orbit = requireContext().getString(R.string.mars_earth),
            type = requireContext().getString(R.string.manmade),
            fair_2 = requireContext().getString(R.string.royalty_landing),
            btc_2 = requireContext().getString(R.string.two_hundred_btc),
            )

        //on click destination
        binding.lytAbujaToMoon.setOnClickListener {
            findNavController().navigate(SelectDestination2FragmentDirections.actionSelectDestination2FragmentToTripDetailsFragment(tripDetails = tripDetails1))
        }

        //on click destination
        binding.lytMarsToInternationalSpace.setOnClickListener {
            findNavController().navigate(SelectDestination2FragmentDirections.actionSelectDestination2FragmentToTripDetailsFragment(tripDetails2))
        }

    }

}