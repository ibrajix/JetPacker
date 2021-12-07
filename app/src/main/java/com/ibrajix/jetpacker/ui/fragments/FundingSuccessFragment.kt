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
import com.ibrajix.jetpacker.databinding.FragmentFundingSuccessBinding
import com.ibrajix.jetpacker.utils.viewBinding

class FundingSuccessFragment : Fragment() {

    private val binding by viewBinding(FragmentFundingSuccessBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_funding_success, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        handleClick()
    }

    private fun handleClick(){

        //on click back
        binding.btnOkay.setOnClickListener {
            findNavController().navigate(FundingSuccessFragmentDirections.actionFundingSuccessFragmentToHomeFragment())
        }

    }

}