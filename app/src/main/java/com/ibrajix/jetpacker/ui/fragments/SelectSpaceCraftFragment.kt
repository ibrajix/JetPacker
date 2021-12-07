/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.jetpacker.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ibrajix.jetpacker.R
import com.ibrajix.jetpacker.databinding.FragmentSelectSpaceCraftBinding
import com.ibrajix.jetpacker.ui.viewmodel.StorageViewModel
import com.ibrajix.jetpacker.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SelectSpaceCraftFragment : Fragment() {

    private val binding by viewBinding(FragmentSelectSpaceCraftBinding::bind)
    private val viewModel: StorageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_space_craft, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        observe()
        handleClicks()
    }

    private fun observe(){
        viewModel.walletBalance.observe(viewLifecycleOwner){

            //check if saved value in data store is equal to the default
            if (!it.equals(requireContext().getString(R.string.zero_btc))){
              binding.lytWalletFunded.visibility = View.VISIBLE
              binding.lytNoFunds.visibility = View.GONE
            }

            else{
                binding.lytWalletFunded.visibility = View.GONE
                binding.lytNoFunds.visibility = View.VISIBLE
            }

        }
    }

    private fun handleClicks(){

        //on click back
        binding.icBack.setOnClickListener {
            findNavController().popBackStack()
        }


        //on click falcon 1
        binding.lytFalcon1.setOnClickListener {
            findNavController().navigate(SelectSpaceCraftFragmentDirections.actionSelectSpaceCraftFragmentToSelectDestinationFragment())
        }

        //on click falcon 9
        binding.lytFalcon9.setOnClickListener {
            findNavController().navigate(SelectSpaceCraftFragmentDirections.actionSelectSpaceCraftFragmentToSelectDestination2Fragment())
        }

        //on click btn fund
        binding.btnFundWallet.setOnClickListener {
            findNavController().navigate(SelectSpaceCraftFragmentDirections.actionSelectSpaceCraftFragmentToFundWalletFragment())
        }

    }

}
