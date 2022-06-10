package com.secondworld.singleuser.domain.repository

import com.secondworld.core.base.BaseResult
import com.secondworld.core.base.Failure
import com.secondworld.singleuser.domain.entity.SingleUserDomain
import kotlinx.coroutines.flow.Flow

interface SingleUserRepository {

    suspend fun fetchSingleUser() : Flow<BaseResult<SingleUserDomain, Failure>>
}