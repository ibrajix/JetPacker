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
import com.ibrajix.jetpacker.databinding.FragmentSelectDestinationBinding
import com.ibrajix.jetpacker.ui.model.TripDetails
import com.ibrajix.jetpacker.utils.viewBinding

class SelectDestinationFragment : Fragment() {

    private val binding by viewBinding(FragmentSelectDestinationBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_destination, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        handleClicks()
    }

    private fun handleClicks(){

        val tripDetails = TripDetails(
            spaceCraft = requireContext().getString(R.string.falcon_1),
            station = requireContext().getString(R.string.moon_to_spook_stations),
            orbit = requireContext().getString(R.string.earth_mass),
            type = requireContext().getString(R.string.natural),
            fair_1 = requireContext().getString(R.string.cross_orbit),
            fair_2 = requireContext().getString(R.string.royalty_landing),
            fair_3 = requireContext().getString(R.string.journey_2_points),
            btc_1 = requireContext().getString(R.string.two_fifty_btc),
            btc_2 = requireContext().getString(R.string.two_hundred_btc),
            btc_3 = requireContext().getString(R.string.fifty_btc),
        )

        //on click back
        binding.icBack.setOnClickListener {
            findNavController().popBackStack()
        }

        //on click destination
        binding.lytFalcon1.setOnClickListener {
            findNavController().navigate(SelectDestinationFragmentDirections.actionSelectDestinationFragmentToTripDetailsFragment(tripDetails = tripDetails))
        }

    }

}