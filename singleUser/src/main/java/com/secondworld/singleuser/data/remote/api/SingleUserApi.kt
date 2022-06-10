package com.secondworld.singleuser.data.remote.api

import com.secondworld.singleuser.data.remote.dto.SingleUserResponse
import retrofit2.Response
import retrofit2.http.GET

interface SingleUserApi {

    @GET("api/users/2")
    suspend fun getSingleUser() : Response<SingleUserResponse>
}