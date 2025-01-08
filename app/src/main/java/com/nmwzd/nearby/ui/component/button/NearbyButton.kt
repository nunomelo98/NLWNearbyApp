package com.nmwzd.nearby.ui.component.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmwzd.nearby.R
import com.nmwzd.nearby.ui.theme.GreenBase
import com.nmwzd.nearby.ui.theme.Typography


/*
* Created by Nuno Melo on 12/13/2024.
* Email : nuno.melo@nmwzd.com
* Copyright (c) 2024 NMWZD. All rights reserved.
*/
@Composable
fun NearbyButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    @DrawableRes iconRes: Int? = null,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.heightIn(min = 56.dp),
        shape = RoundedCornerShape(16.dp),
        contentPadding = if (text == null && iconRes != null) PaddingValues(0.dp) else ButtonDefaults.ContentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenBase,
        ),
        onClick = onClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            iconRes?.let {
                Icon(painter = painterResource(id = iconRes), contentDescription = "Icon do botão")
            }
            text?.let { Text(text = text.uppercase(), style = Typography.labelLarge) }
        }


    }
}

@Preview
@Composable
private fun NearbyButtonPreview() {
    NearbyButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Confirm",
        iconRes = R.drawable.ic_scan
    ) { }

}

@Preview
@Composable
private fun NearbyButtonNoIconPreview() {
    NearbyButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Confirm"
    ) { }

}

@Preview
@Composable
private fun NearbyButtonNoTextPreview() {
    NearbyButton(
        modifier = Modifier,
        iconRes = R.drawable.ic_arrow_left
    ) { }

}