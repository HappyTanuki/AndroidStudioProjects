package com.my.kiosk.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.my.kiosk.MenuEntityData
import com.my.kiosk.MenuEntityDataClass
import com.my.kiosk.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Thread.sleep
import java.time.LocalDateTime

@Composable
fun MenuEntity(
    modifier: Modifier = Modifier,
    data: MenuEntityData
    ) {
    Column(
        modifier = modifier
            .padding(10.dp)
            .wrapContentSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoadingEntity(modifier = Modifier.weight(5f), !data.loaded) {
            AsyncImage(
                modifier = Modifier
                    .weight(3f),
                model = data.url,
                contentDescription = data.name
            )
        }
        LoadingEntity(modifier = Modifier.weight(3f), !data.loaded) {
            Text(
                text = data.name,
                fontSize = 10.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(0.dp, 10.dp, 0.dp, 0.dp)
                    .wrapContentSize(),
                textAlign = TextAlign.Center
            )
        }
        LoadingEntity(modifier = Modifier.weight(3f), !data.loaded) {
            Text(
                text = "₩${data.price}",
                fontSize = 10.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(0.dp, 0.dp, 0.dp, 0.dp)
                    .wrapContentSize()
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MenuEntityPreview() {
    MenuEntity(
        modifier = Modifier
            .requiredSize(100.dp, 150.dp),
        MenuEntityData(
            MenuEntityDataClass(
                "class1",
                0
            ),
            true,
            "R.drawable.profile",
            "HappyTanuki",
            10000,
            true
        )
    )
}