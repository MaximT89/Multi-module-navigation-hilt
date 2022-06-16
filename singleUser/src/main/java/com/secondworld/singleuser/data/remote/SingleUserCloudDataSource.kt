package com.secondworld.singleuser.data.remote

import com.secondworld.core.base.BaseResult
import com.secondworld.core.base.Failure
import com.secondworld.core.base.ResponseWrapper
import com.secondworld.singleuser.domain.entity.SingleUserDomain
import com.secondworld.singleuser.data.remote.api.SingleUserApi
import javax.inject.Inject

class SingleUserCloudDataSource @Inject constructor(
    private val api: SingleUserApi,
    private val mapper: SingleUserResponseToDomainMapper,
    private val responseWrapper: ResponseWrapper
) {

    suspend fun fetchSingleUser(): BaseResult<SingleUserDomain, Failure> =
        responseWrapper.handleResponse(mapper) {
            api.getSingleUser()
        }
}