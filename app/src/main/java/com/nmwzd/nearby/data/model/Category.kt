package com.nmwzd.nearby.data.model

import androidx.annotation.DrawableRes
import com.nmwzd.nearby.ui.component.category.CategoryFilterChipView
import kotlinx.serialization.Serializable


/*
* Created by Nuno Melo on 12/13/2024.
* Email : nuno.melo@nmwzd.com
* Copyright (c) 2024 NMWZD. All rights reserved.
*/
@Serializable
data class Category(
    val id: String,
    val name: String
){
    @get:DrawableRes
    val icon: Int?
        get() = CategoryFilterChipView.Companion.fromDescription(description  = name)?.icon
}
