package com.secondworld.singleuser.data.remote

import com.secondworld.core.base.BaseResult
import com.secondworld.core.base.Failure
import com.secondworld.singleuser.domain.entity.SingleUserDomain
import com.secondworld.core.remote.NoInternetConnectionException
import com.secondworld.singleuser.data.remote.api.SingleUserApi
import javax.inject.Inject

class SingleUserCloudDataSource @Inject constructor(
    private val api: SingleUserApi,
    private val mapper: SingleUserResponseToDomainMapper
) {

    suspend fun fetchSingleUser(): BaseResult<SingleUserDomain, Failure> {
        return try {
            val response = api.getSingleUser()
            if (response.isSuccessful) {
                val body = response.body()
                BaseResult.Success(mapper.map(body!!))
            } else {
                BaseResult.Error(Failure(response.code(), response.message()))
            }
        } catch (e: NoInternetConnectionException) {
            BaseResult.Error(Failure(0, e.message))
        } catch (e: Exception) {
            BaseResult.Error(Failure(-1, e.message.toString()))
        }
    }
}