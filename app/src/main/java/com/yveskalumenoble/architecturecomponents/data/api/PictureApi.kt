package com.yveskalumenoble.architecturecomponents.data.api

import com.yveskalumenoble.architecturecomponents.data.entity.PictureResponse
import retrofit2.Call
import retrofit2.http.GET



interface PictureApi {
    @GET("")
    fun getPictures(): Call<PictureResponse>
}