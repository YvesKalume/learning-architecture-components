package com.yveskalumenoble.architecturecomponents.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yveskalumenoble.architecturecomponents.data.entity.Picture
import com.yveskalumenoble.architecturecomponents.data.room.dao.PictureDao

@Database(entities = [Picture::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val pictureDao : PictureDao
}