package com.yveskalumenoble.architecturecomponents.data.entity

data class PictureResponse(
    val total: String,
    var totalHits: String,
    var hits: List<Picture>
)