package com.nmwzd.nearby.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


/*
* Created by Nuno Melo on 1/14/2025.
* Email : nuno.melo@nmwzd.com
* Copyright (c) 2025 NMWZD. All rights reserved.
*/
object KtorHttpClient {
    private const val NETWORK_TIMEOUT = 5_000L
    val httpClientAndroid by lazy {
        HttpClient(Android){
            install(ContentNegotiation){
                json(
                    Json{
                        prettyPrint = true
                        isLenient = true
                        useAlternativeNames = true
                        ignoreUnknownKeys = true
                        explicitNulls = true
                        useArrayPolymorphism = true
                        encodeDefaults = false
                    }
                )
            }
            install(HttpTimeout){
                requestTimeoutMillis = NETWORK_TIMEOUT
                connectTimeoutMillis = NETWORK_TIMEOUT
                socketTimeoutMillis = NETWORK_TIMEOUT
            }

            install(Logging){
                level = LogLevel.ALL
            }

        }
    }
}