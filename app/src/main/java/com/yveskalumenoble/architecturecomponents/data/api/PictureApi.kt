package com.yveskalumenoble.architecturecomponents.data.api

import com.yveskalumenoble.architecturecomponents.data.entity.PictureResponse
import com.yveskalumenoble.architecturecomponents.util.CONSTANT
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PictureApi {
    @GET("api/")
    fun getPicturesAsync(@Query("key") key : String): Deferred<PictureResponse>
}