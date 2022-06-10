package com.secondworld.singleuser.data

import com.secondworld.singleuser.data.remote.SingleUserCloudDataSource
import com.secondworld.core.base.BaseResult
import com.secondworld.core.base.Failure
import com.secondworld.singleuser.domain.entity.SingleUserDomain
import com.secondworld.singleuser.domain.repository.SingleUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SingleUserRepositoryImpl @Inject constructor(
    private val cloudDataSource: SingleUserCloudDataSource
) : SingleUserRepository {

    override suspend fun fetchSingleUser(): Flow<BaseResult<SingleUserDomain, Failure>> =
        flow {
            val result = cloudDataSource.fetchSingleUser()
            emit(result)
        }
}