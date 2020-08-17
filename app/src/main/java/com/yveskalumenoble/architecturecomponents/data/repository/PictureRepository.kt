package com.yveskalumenoble.architecturecomponents.data.repository

import com.yveskalumenoble.architecturecomponents.data.api.PictureApi

class PictureRepository(private val api: PictureApi) {
    fun getAll() = api.getPictures()
}