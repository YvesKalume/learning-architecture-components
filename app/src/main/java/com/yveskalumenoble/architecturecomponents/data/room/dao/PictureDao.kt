package com.yveskalumenoble.architecturecomponents.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yveskalumenoble.architecturecomponents.data.entity.Picture

@Dao
interface PictureDao {

    @Query("SELECT * FROM pictures")
    fun getPictures() : LiveData<List<Picture>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPictures(pictures: List<Picture>)
}