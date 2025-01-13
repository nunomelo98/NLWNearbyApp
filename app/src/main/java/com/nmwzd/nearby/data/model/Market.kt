package com.nmwzd.nearby.data.model

import kotlinx.serialization.Serializable


/*
* Created by Nuno Melo on 1/3/2025.
* Email : nuno.melo@nmwzd.com
* Copyright (c) 2025 NMWZD. All rights reserved.
*/
@Serializable
data class Market(
    val id: String,
    val categoryId: String,
    val name: String,
    val description: String,
    val coupons: Int,
    //val rules: List<Rule> = emptyList(), isto é removido por causa do mapeamento da nossa API
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val phone: String,
    val cover: String,
)
