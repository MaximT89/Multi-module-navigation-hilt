package com.secondworld.listusers.presentation

import androidx.lifecycle.ViewModel
import com.secondworld.listusers.navigation.Destinations
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListUserViewModel @Inject constructor() : ViewModel() {

    fun navigateToDetail() = Destinations.DETAIL.id
}