package com.secondworld.singleuser.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SingleUserResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("support")
	val support: Support? = null
)

data class Data(

	@field:SerializedName("last_name")
	val lastName: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("avatar")
	val avatar: String? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class Support(

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
