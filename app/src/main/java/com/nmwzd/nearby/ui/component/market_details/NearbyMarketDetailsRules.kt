package com.nmwzd.nearby.ui.component.market_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nmwzd.nearby.data.model.Rule
import com.nmwzd.nearby.data.model.mock.mockRules
import com.nmwzd.nearby.ui.theme.Gray400
import com.nmwzd.nearby.ui.theme.Gray500
import com.nmwzd.nearby.ui.theme.Typography


/*
* Created by Nuno Melo on 1/7/2025.
* Email : nuno.melo@nmwzd.com
* Copyright (c) 2025 NMWZD. All rights reserved.
*/
@Composable
fun NearbyMarketDetailsRules(modifier: Modifier = Modifier, rules: List<Rule>) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
        Text(text = "Regulamento", style = Typography.headlineSmall, color = Gray400)

        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = rules.joinToString(separator = "\n", transform = {"• ${it.description}" }),
            style = Typography.labelMedium,
            lineHeight = 24.sp,
            color = Gray500

        )

    }
}

@Preview
@Composable
private fun MarketDetailsRulesPreview() {
    NearbyMarketDetailsRules(
        modifier = Modifier.fillMaxWidth(),
        rules = mockRules
    )

}