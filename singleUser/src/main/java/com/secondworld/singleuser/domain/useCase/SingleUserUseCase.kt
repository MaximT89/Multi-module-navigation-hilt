package com.secondworld.singleuser.domain.useCase

import com.secondworld.core.base.BaseResult
import com.secondworld.core.base.BaseUseCase
import com.secondworld.core.base.Failure
import com.secondworld.singleuser.domain.entity.SingleUserDomain
import com.secondworld.singleuser.domain.repository.SingleUserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SingleUserUseCase @Inject constructor(private val repository: SingleUserRepository) :
    BaseUseCase<BaseResult<SingleUserDomain, Failure>> {

    override suspend fun execute(): Flow<BaseResult<SingleUserDomain, Failure>> {
        return repository.fetchSingleUser()
    }
}