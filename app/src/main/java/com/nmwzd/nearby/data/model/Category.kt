package com.nmwzd.nearby.data.model

import androidx.annotation.DrawableRes



/*
* Created by Nuno Melo on 12/13/2024.
* Email : nuno.melo@nmwzd.com
* Copyright (c) 2024 NMWZD. All rights reserved.
*/
data class Category(
    val id: String,
    val name: String
){
    @get:DrawableRes
    val icon: Int?
        get() = CategoryFilterChipView.fromDescription(description  = name)?.icon
}
