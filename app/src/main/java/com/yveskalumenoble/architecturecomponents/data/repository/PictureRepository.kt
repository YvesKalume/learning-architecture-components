package com.yveskalumenoble.architecturecomponents.data.repository

import com.yveskalumenoble.architecturecomponents.data.api.PictureApi
import com.yveskalumenoble.architecturecomponents.util.CONSTANT

class PictureRepository(private val api: PictureApi) {
    fun getAll() = api.getPicturesAsync(CONSTANT.API_KEY)
}