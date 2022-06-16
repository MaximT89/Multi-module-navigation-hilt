package com.secondworld.core.base

import com.secondworld.core.Mapper
import com.secondworld.core.remote.NoInternetConnectionException
import retrofit2.Response
import javax.inject.Inject

interface ResponseWrapper {

    suspend fun <T, R> handleResponse(
        mapper: Mapper.Data<T, R>,
        apiRequest: suspend () -> Response<T>
    ) : BaseResult<R, Failure>

    class Base @Inject constructor(): ResponseWrapper{
        override suspend fun <T, R> handleResponse(
            mapper: Mapper.Data<T, R>,
            apiRequest: suspend () -> Response<T>
        ): BaseResult<R, Failure> {
            return try {
                val response = apiRequest.invoke()

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
}