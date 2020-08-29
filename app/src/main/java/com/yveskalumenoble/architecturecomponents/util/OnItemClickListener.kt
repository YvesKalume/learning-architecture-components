package com.yveskalumenoble.architecturecomponents.util

import com.yveskalumenoble.architecturecomponents.data.entity.Picture

interface OnItemClickListener {
    fun onItemClick(picture: Picture)
}