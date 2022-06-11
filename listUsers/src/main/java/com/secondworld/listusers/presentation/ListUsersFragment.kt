package com.secondworld.listusers.presentation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.secondworld.core.base.BaseFragment
import com.secondworld.listusers.databinding.FragmentListUsersBinding
import com.secondworld.singleuser.domain.entity.SingleUserDomain
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListUsersFragment : BaseFragment<FragmentListUsersBinding>(FragmentListUsersBinding::inflate) {

    private val viewModel : ListUserViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getInfo()
        initView()
    }

    private fun getInfo() {

    }

    private fun initView() = with(binding) {
        btnGoDetail.setOnClickListener {
            val bundle = bundleOf("s1" to "Max")
            findNavController().navigate(viewModel.navigateToDetail(), bundle)
        }
    }
}