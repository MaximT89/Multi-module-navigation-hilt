package com.secondworld.core.base

import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible

fun View.show(){
    isVisible = true
}

fun View.hide(){
    isGone = true
}

fun showViews(vararg views :View){
    views.forEach { it.isVisible = true }
}

fun hideViews(vararg views :View){
    views.forEach { it.isGone = true }
}