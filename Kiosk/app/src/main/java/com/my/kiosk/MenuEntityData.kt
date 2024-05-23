package com.my.kiosk

import androidx.annotation.DrawableRes

data class MenuEntityData(
    @DrawableRes val imageID: Int,
    val name: String,
    val price: Int
)
