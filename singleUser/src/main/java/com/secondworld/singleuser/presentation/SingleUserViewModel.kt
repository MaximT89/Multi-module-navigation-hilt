package com.secondworld.singleuser.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.secondworld.core.base.BaseResult
import com.secondworld.core.base.Dispatchers
import com.secondworld.core.base.ResourceProvider
import com.secondworld.singleuser.R
import com.secondworld.singleuser.domain.entity.SingleUserDomain
import com.secondworld.singleuser.domain.useCase.SingleUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject


@HiltViewModel
class SingleUserViewModel @Inject constructor(
    private val useCase: SingleUserUseCase,
    private val dispatchers: Dispatchers.Base,
    private val resourceProvider: ResourceProvider.Base
) : ViewModel() {

    private var _state: MutableSharedFlow<SingleUserState> = MutableSharedFlow()
    val state = _state.asSharedFlow()

    init {
        fetchData()
    }

    fun fetchData() {
        dispatchers.launchBackground(viewModelScope) {
            useCase.execute()
                .onStart {
                    loading()
                }
                .collect { result ->
                    when (result) {
                        is BaseResult.Success -> _state.emit(SingleUserState.Success(result.data))
                        is BaseResult.Error -> {
                            if (result.err.code != 0) {
                                _state.emit(SingleUserState.Error("${result.err.message} [${result.err.code}]"))
                            } else {
                                _state.emit(SingleUserState.NoInternet(resourceProvider.string(R.string.no_internet)))
                            }
                        }
                    }
                }
        }
    }

    private suspend fun loading() {
        _state.emit(SingleUserState.Loading)
    }
}

sealed class SingleUserState {

    object Loading : SingleUserState()
    class Success(val data: SingleUserDomain) : SingleUserState()
    class Error(val message: String) : SingleUserState()
    class NoInternet(val message: String) : SingleUserState()
}