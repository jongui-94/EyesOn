package com.d201.data.datasource

import com.d201.data.api.UserApi
import com.d201.data.model.request.AngelRequest
import com.d201.data.model.request.UserRequest
import com.d201.data.model.request.UserRoleRequest
import com.d201.data.model.response.AngelInfoResponse
import com.d201.data.model.response.LoginResponse
import com.d201.domain.base.BaseResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRemoteDataSource @Inject constructor(
    private val userApi: UserApi
) {

    fun loginUser(userRequest: UserRequest): Flow<BaseResponse<LoginResponse>> = flow {
        emit(userApi.loginUser(userRequest))
    }

    fun getAngelInfo(): Flow<BaseResponse<AngelInfoResponse>> = flow {
        emit(userApi.getAngelInfo())
    }

    fun putUserRole(userRoleRequest: UserRoleRequest): Flow<BaseResponse<LoginResponse>> = flow {
        emit(userApi.putUserRole(userRoleRequest))
    }

    fun putAngelInfo(angelRequest: AngelRequest): Flow<BaseResponse<AngelInfoResponse>> = flow {
        emit(userApi.putAngelInfo(angelRequest))
    }

    fun deleteUser(): Flow<BaseResponse<Void>> = flow {
        emit(userApi.deleteUser())
    }

}