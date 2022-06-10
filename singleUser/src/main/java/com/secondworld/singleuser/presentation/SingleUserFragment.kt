package com.secondworld.singleuser.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.secondworld.core.base.*
import com.secondworld.singleuser.databinding.FragmentSingleUserBinding
import com.secondworld.singleuser.domain.entity.SingleUserDomain
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SingleUserFragment :
    BaseFragment<FragmentSingleUserBinding>(FragmentSingleUserBinding::inflate) {

    private val viewModel: SingleUserViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initData()
    }

    private fun initData() {
        lifecycleScope.launchWhenCreated {
            viewModel.state.collect { result ->
                when (result) {
                    SingleUserState.Loading -> isLoading(true)
                    is SingleUserState.Success -> {
                        isLoading(false)
                        updateContent(result.data)
                    }
                    is SingleUserState.Error -> {
                        isError(true)
                        errorMessage(result.message)
                    }
                    is SingleUserState.NoInternet -> {
                        isError(true)
                        errorMessage(result.message)
                    }
                }
            }
        }
    }

    private fun updateContent(data: SingleUserDomain) = with(binding){
        firstName.text = data.firstName
        lastName.text = data.lastName
        email.text = data.email
    }

    private fun isError(status: Boolean) {
        with(binding) {
            when (status) {
                true -> {
                    content.hide()
                    error.show()
                }
                false -> error.hide()
            }
        }
    }

    private fun errorMessage(message: String) {
        binding.error.text = message
    }

    private fun isLoading(status: Boolean) = with(binding) {
        when (status) {
            false -> {
                content.show()
                progressBar.hide()
                isError(false)
            }
            true -> {
                content.hide()
                progressBar.show()
                isError(false)
            }

        }
    }

    private fun initView() = with(binding) {
        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        btnRefresh.setOnClickListener {
            viewModel.fetchData()
        }
    }
}