package com.d201.data.api

import com.d201.data.model.request.ComplaintsRequest
import com.d201.data.model.response.ResponseCompDto
import com.d201.domain.base.BaseResponse
import com.d201.domain.model.PagingResult
import retrofit2.http.*

interface ComplaintsApi {

    @POST("complaints/register")
    suspend fun insertComp(@Body complaintsRequest: ComplaintsRequest): BaseResponse<Void>

    @GET("complaints/list")
    suspend fun selectAllComplaints(@Query("page") page: Int, @Query("size") size: Int): BaseResponse<PagingResult<ResponseCompDto>>

    @GET("complaints/list/angel")
    suspend fun selectComplaintsByAngel(@Query("page") page: Int, @Query("size") size: Int): BaseResponse<PagingResult<ResponseCompDto>>

    @GET("complaints/list/blind")
    suspend fun selectComplaintsByBlind(@Query("page") page: Int, @Query("size") size: Int): BaseResponse<PagingResult<ResponseCompDto>>

    @GET("complaints/{complaintsSeq}")
    suspend fun selectComplaintsBySeq(@Path("complaintsSeq") seq: Int): BaseResponse<ResponseCompDto>

    @PUT("complaints/return")
    suspend fun returnComplaints(@Body complaintsRequest: ComplaintsRequest): BaseResponse<Void>

    @PUT("complaints/submit")
    suspend fun submitComplaints(@Body complaintsRequest: ComplaintsRequest): BaseResponse<Void>

    @PUT("complaints/complete")
    suspend fun completeComplaints(@Body complaintsRequest: ComplaintsRequest): BaseResponse<Void>
}