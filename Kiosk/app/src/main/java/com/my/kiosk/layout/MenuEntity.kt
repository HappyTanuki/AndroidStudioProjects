package com.my.kiosk.layout

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.my.kiosk.R

class MenuEntity {
    @Composable
    operator fun invoke(
        @DrawableRes imageId: Int,
        name: String,
        price: Long
    ) {
        Column (
            modifier = Modifier
                .padding(10.dp)
                .wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = imageId),
                contentDescription = name
            )
            Text(
                text = name,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(0.dp, 10.dp, 0.dp, 0.dp)
                    .wrapContentSize()
            )
            Text(
                text = "₩$price",
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(0.dp, 5.dp, 0.dp, 0.dp)
                    .wrapContentSize()
            )
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        this(
            R.drawable.profile,
            "HappyTanuki",
            100000000000
        )
    }
}