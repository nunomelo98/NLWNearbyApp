package com.nmwzd.nearby.core.network

import com.nmwzd.nearby.core.network.KtorHttpClient.httpClientAndroid
import com.nmwzd.nearby.data.model.Category
import com.nmwzd.nearby.data.model.Coupon
import com.nmwzd.nearby.data.model.Market
import com.nmwzd.nearby.data.model.MarketDetails
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch


/*
* Created by Nuno Melo on 1/15/2025.
* Email : nuno.melo@nmwzd.com
* Copyright (c) 2025 NMWZD. All rights reserved.
*/
object NearbyRemoteDataSource {

    private val  LOCAL_HOST_EMULATOR_BASE_URL = "http://10.0.2.2:3333"

    private val BASE_URL = LOCAL_HOST_EMULATOR_BASE_URL

    // 1- BUSCA DE CATEGORIAS
    // 2- BUSCA DE LOCAIS (COM BSE NUMA CATEGORIA)
    // 3- BUSCA DE DETALHES DE UM LOCAL (COM BASE EM UM LOCAL ESPECIFICO)
    // 4- GERAR CUPOM  A PARTIR DA LEITURA DO QR CODE

    suspend fun getCategories(): Result<List<Category>> = try{
        val categories = httpClientAndroid.get("$BASE_URL/categories").body<List<Category>>()
        Result.success(categories)

    } catch(e: Exception){
        Result.failure(e)

    }

    suspend fun getMarkets(categoryId: String): Result<List<Market>> = try{
        val markets = httpClientAndroid.get("$BASE_URL/markets/category/${categoryId}").body<List<Market>>()
        Result.success(markets)
    } catch(e: Exception){
        Result.failure(e)

    }

    suspend fun getMarketsDetails(marketId: String): Result<MarketDetails> = try{
        val markets = httpClientAndroid.get("$BASE_URL/markets/${marketId}").body<MarketDetails>()
        Result.success(markets)

    } catch(e: Exception){
        Result.failure(e)
    }

    suspend fun patchCoupon(marketId: String): Result<Coupon> = try{
        val coupon = httpClientAndroid.patch("$BASE_URL/coupon/${marketId}").body<Coupon>()
        Result.success(coupon)

    } catch (e: Exception){
        Result.failure(e)

    }
}