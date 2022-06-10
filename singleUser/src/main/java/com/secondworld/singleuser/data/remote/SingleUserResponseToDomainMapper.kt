package com.secondworld.singleuser.data.remote

import com.secondworld.core.Mapper
import com.secondworld.singleuser.data.remote.dto.SingleUserResponse
import com.secondworld.singleuser.domain.entity.SingleUserDomain
import javax.inject.Inject

class SingleUserResponseToDomainMapper @Inject constructor():
    Mapper<SingleUserResponse, SingleUserDomain> {

    override fun map(data: SingleUserResponse): SingleUserDomain {
        return SingleUserDomain(
            data.data?.lastName,
            data.data?.id,
            data.data?.avatar,
            data.data?.firstName,
            data.data?.email
        )
    }
}