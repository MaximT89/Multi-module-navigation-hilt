package com.secondworld.singleuser.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SingleUserDomain(
    val lastName: String? = null,
    val id: Int? = null,
    val avatar: String? = null,
    val firstName: String? = null,
    val email: String? = null
) : Parcelable