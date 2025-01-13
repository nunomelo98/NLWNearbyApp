package com.nmwzd.nearby.data.model

import kotlinx.serialization.Serializable


/*
* Created by Nuno Melo on 1/3/2025.
* Email : nuno.melo@nmwzd.com
* Copyright (c) 2025 NMWZD. All rights reserved.
*/
@Serializable
data class Rule(
    val id: String,
    val description: String,
    val marketId: String

)