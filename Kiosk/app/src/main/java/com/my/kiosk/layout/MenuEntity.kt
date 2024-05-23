package com.my.kiosk.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.my.kiosk.MenuEntityData
import com.my.kiosk.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Thread.sleep
import java.time.LocalDateTime

class MenuEntity() {
    @Composable
    operator fun invoke(data: MenuEntityData) {
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
                painter = painterResource(id = data.imageID),
                contentDescription = data.name
            )
            Text(
                text = data.name,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(0.dp, 10.dp, 0.dp, 0.dp)
                    .wrapContentSize()
            )
            Text(
                text = "₩${data.price}",
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
        this( MenuEntityData(
            R.drawable.profile,
            "HappyTanuki",
            10000)
        )
    }
}