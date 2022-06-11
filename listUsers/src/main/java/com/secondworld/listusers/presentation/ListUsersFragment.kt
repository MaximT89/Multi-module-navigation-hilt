package com.secondworld.listusers.presentation

import android.os.Bundle
import android.view.View
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
        setFragmentResultListener("data") { _, bundle ->
            val entity = bundle.getParcelable<SingleUserDomain>("entity")
            entity?.let {
                binding.lastName.text = it.lastName
            }
        }
    }

    private fun initView() = with(binding) {
        btnGoDetail.setOnClickListener {
            findNavController().navigate(viewModel.navigateToDetail())
        }
    }
}