package com.yveskalumenoble.architecturecomponents.data.repository

import android.util.Log
import com.yveskalumenoble.architecturecomponents.data.api.PictureApi
import com.yveskalumenoble.architecturecomponents.data.entity.Picture
import com.yveskalumenoble.architecturecomponents.data.room.dao.PictureDao
import com.yveskalumenoble.architecturecomponents.util.CONSTANT
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PictureRepository(private val api: PictureApi, private val pictureDao: PictureDao) {

    val data = pictureDao.getPictures()

    suspend fun refreshData() {
        withContext(Dispatchers.IO) {
            val pictures = api.getPicturesAsync(CONSTANT.API_KEY).await().hits
            pictureDao.insertPictures(pictures)
        }
    }
}