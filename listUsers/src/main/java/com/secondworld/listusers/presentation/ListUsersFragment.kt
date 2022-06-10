package com.secondworld.listusers.presentation

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.secondworld.core.base.BaseFragment
import com.secondworld.listusers.R
import com.secondworld.listusers.databinding.FragmentListUsersBinding
import com.secondworld.listusers.navigation.Destinations
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListUsersFragment : BaseFragment<FragmentListUsersBinding>(FragmentListUsersBinding::inflate) {

    private val viewModel : ListUserViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() = with(binding) {
        btnGoDetail.setOnClickListener {
            findNavController().navigate(viewModel.navigateToDetail())
        }
    }
}