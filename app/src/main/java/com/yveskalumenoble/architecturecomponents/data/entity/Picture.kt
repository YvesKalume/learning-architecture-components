package com.yveskalumenoble.architecturecomponents.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "pictures")
@Parcelize
data class Picture(
    @PrimaryKey var id: String,
    val pageUrl: String?,
    val type: String?,
    val tags: String?,
    val previewURL: String?,
    val previewWidth: String?,
    val previewHeight: String?,
    val webformatURL: String?,
    val webformatWidth: String?,
    val webformatHeight: String?,
    val largeImageURL: String?,
    val imageWidth: String?,
    val imageHeight: String?,
    val imageSize: String?,
    val views: String?,
    val downloads: String?,
    val favorites: String?,
    val likes: String?,
    val comments: String?,
    val user_id: String?,
    val user: String?,
    val userImageURL: String?
) : Parcelable