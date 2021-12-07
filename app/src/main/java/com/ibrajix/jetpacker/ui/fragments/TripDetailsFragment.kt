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
import androidx.navigation.fragment.navArgs
import com.ibrajix.jetpacker.R
import com.ibrajix.jetpacker.databinding.FragmentTripDetailsBinding
import com.ibrajix.jetpacker.utils.viewBinding

class TripDetailsFragment : Fragment() {

    private val binding by viewBinding(FragmentTripDetailsBinding::bind)
    private val args: TripDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trip_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){

        setView()

        handleClicks()
    }

    private fun setView(){

        binding.txtBtc1.text = args.tripDetails.btc_1
        binding.txtBtc2.text = args.tripDetails.btc_2
        binding.txtBtc3.text = args.tripDetails.btc_3
        binding.txtFair1.text = args.tripDetails.fair_1
        binding.txtFair2.text = args.tripDetails.fair_2
        binding.txtFair3.text = args.tripDetails.fair_3
        binding.txtOrbit.text = args.tripDetails.orbit
        binding.txtSpaceCraft.text = args.tripDetails.spaceCraft
        binding.txtStation.text = args.tripDetails.station
        binding.txtType.text = args.tripDetails.type

    }

    private fun handleClicks(){

        //on click back
        binding.icBack.setOnClickListener {
            findNavController().popBackStack()
        }

        //on click begin trip
        binding.btnBeginTrip.setOnClickListener {
            findNavController().navigate(TripDetailsFragmentDirections.actionTripDetailsFragmentToEnjoyRideFragment())
        }

    }

}