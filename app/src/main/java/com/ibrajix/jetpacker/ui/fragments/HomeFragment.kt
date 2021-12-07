/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.jetpacker.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ibrajix.jetpacker.R
import com.ibrajix.jetpacker.databinding.FragmentHomeBinding
import com.ibrajix.jetpacker.ui.viewmodel.StorageViewModel
import com.ibrajix.jetpacker.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: StorageViewModel by viewModels()
    private var walletBalance: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        observe()
        handleClicks()
    }

    /**
     * Observe changes to wallet balance - livedata
     */

    private fun observe(){

        viewModel.walletBalance.observe(viewLifecycleOwner){
             walletBalance  = it
             binding.txtBtcAmount.text = walletBalance
        }

    }


    private fun handleClicks(){

        //on click btn fund wallet
        binding.btnFundWallet.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFundWalletFragment())
        }

        //on click start journey
        binding.lytStartJourney.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSelectSpaceCraftFragment())
        }

    }

}