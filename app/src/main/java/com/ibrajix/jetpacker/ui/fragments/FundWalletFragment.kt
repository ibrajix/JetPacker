/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.jetpacker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ibrajix.jetpacker.R
import com.ibrajix.jetpacker.databinding.FragmentFundWalletBinding
import com.ibrajix.jetpacker.ui.viewmodel.StorageViewModel
import com.ibrajix.jetpacker.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FundWalletFragment : Fragment() {

    private val viewModel: StorageViewModel by viewModels()

    private val binding by viewBinding(FragmentFundWalletBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fund_wallet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        handleClicks()
    }

    private fun handleClicks(){

        //on click back
        binding.icBack.setOnClickListener {
            findNavController().popBackStack()
        }

        //on click button fund wallet
        binding.btnFundWallet.setOnClickListener {

            //set balance
            viewModel.changeWalletBalance(binding.editText.text.toString())

            //navigate to success screen
            findNavController().navigate(FundWalletFragmentDirections.actionFundWalletFragmentToFundingSuccessFragment())
        }

    }
}