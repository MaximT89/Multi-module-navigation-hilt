package com.secondworld.singleuser.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.secondworld.core.base.BaseFragment
import com.secondworld.singleuser.R
import com.secondworld.singleuser.databinding.FragmentSingleUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleUserFragment : BaseFragment<FragmentSingleUserBinding>(FragmentSingleUserBinding::inflate) {

    private val viewModel : SingleUserViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() = with(binding){
        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}