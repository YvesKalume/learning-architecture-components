package com.yveskalumenoble.architecturecomponents.data.api

import com.yveskalumenoble.architecturecomponents.data.entity.PictureResponse
import com.yveskalumenoble.architecturecomponents.util.CONSTANT
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PictureApi {
    @GET("api/")
    fun getPictures(@Query("key") key : String): Call<PictureResponse>
}