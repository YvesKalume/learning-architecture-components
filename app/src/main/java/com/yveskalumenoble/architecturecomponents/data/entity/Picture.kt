package com.yveskalumenoble.architecturecomponents.data.entity

data class Picture(
    var id: String,
    var pageUrl: String,
    var type: String,
    var tags: String,
    var previewURL: String,
    var previewWidth: String,
    var previewHeight: String,
    var webformatURL: String,
    var webformatWidth: String,
    var webformatHeight: String,
    var largeImageURL: String,
    var fullHDURL: String,
    var imageURL: String,
    var imageWidth: String,
    var imageHeight: String,
    var imageSize: String,
    var views: String,
    var downloads: String,
    var favorites: String,
    var likes: String,
    var comments: String,
    var user_id: String,
    var user: String,
    var userImageURL: String
)