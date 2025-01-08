package com.nmwzd.nearby.ui.component.market_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmwzd.nearby.data.model.Market
import com.nmwzd.nearby.ui.theme.Gray400
import com.nmwzd.nearby.ui.theme.Typography
import com.nmwzd.nearby.R
import com.nmwzd.nearby.data.model.mock.mockMarkets
import com.nmwzd.nearby.ui.theme.Gray500


/*
* Created by Nuno Melo on 1/7/2025.
* Email : nuno.melo@nmwzd.com
* Copyright (c) 2025 NMWZD. All rights reserved.
*/
@Composable
fun NearbyMarketDetailsInfos(
    modifier: Modifier = Modifier,
    market: Market
){
    Column (modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(text = "Informações", style = Typography.headlineSmall, color = Gray400)

        Column (verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row (horizontalArrangement = Arrangement.spacedBy(8.dp)){
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_ticket),
                    tint = Gray500,
                    contentDescription = "Ícone de Cupons"
                )
                Text(
                    text = "${market.coupons} cupons disponíveis",
                    style = Typography.labelMedium,
                    color = Gray500

                )
            }

            Row (horizontalArrangement = Arrangement.spacedBy(8.dp)){
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_map_pin),
                    tint = Gray500,
                    contentDescription = "Ícone de Endereço"
                )
                Text(
                    text = market.address,
                    style = Typography.labelMedium,
                    color = Gray500

                )
            }

            Row (horizontalArrangement = Arrangement.spacedBy(8.dp)){
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_phone),
                    tint = Gray500,
                    contentDescription = "Ícone de Telefone"
                )
                Text(
                    text = market.phone,
                    style = Typography.labelMedium,
                    color = Gray500

                )
            }
        }
    }
}

@Preview
@Composable
private fun MarketDetailsInfosPreview() {
    NearbyMarketDetailsInfos(
        modifier = Modifier.fillMaxWidth(),
        market = mockMarkets.first())
}