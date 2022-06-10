package com.secondworld.listusers.navigation

import androidx.annotation.IdRes

internal enum class Destinations(@IdRes val id : Int) {

    DETAIL(com.secondworld.navigation.R.id.action_listUsersFragment_to_singleUserFragment)
}