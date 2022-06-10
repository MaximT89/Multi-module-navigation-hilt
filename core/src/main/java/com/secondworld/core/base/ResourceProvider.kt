package com.secondworld.core.base

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface ResourceProvider{

    fun string(@StringRes id: Int): String
    fun string(@StringRes id: Int, vararg args: Any): String

    class Base @Inject constructor(@ApplicationContext private val context: Context) : ResourceProvider{
        override fun string(id: Int) = context.getString(id)
        override fun string(id: Int, vararg args: Any) = context.getString(id, *args)
    }
}