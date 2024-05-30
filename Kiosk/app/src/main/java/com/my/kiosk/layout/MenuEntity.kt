package com.my.kiosk.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.my.kiosk.Beverage

@Composable
fun MenuEntity(
    isShoppingCart: Boolean = false,
    modifier: Modifier = Modifier,
    data: MutableState<Beverage>
    ) {
    Column(
        modifier = modifier
            .padding(10.dp)
            .wrapContentSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .weight(3f),
            model = data.value.imgURL,
            contentDescription = data.value.name.value
        )
        Text(
            text = data.value.name.value,
            fontSize = 10.sp,
            modifier = Modifier
                .weight(1f)
                .padding(0.dp, 10.dp, 0.dp, 0.dp)
                .wrapContentSize(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "₩${data.value.price.value + data.value.optPrice}",
            fontSize = 10.sp,
            modifier = Modifier
                .weight(1f)
                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                .wrapContentSize()
        )
        if (isShoppingCart) {
            Text(
                text = "${data.value.quantity.value} 개",
                fontSize = 10.sp,
                modifier = Modifier
                    .wrapContentSize()
            )
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun MenuEntityPreview() {
//    MenuEntity(
//        modifier = Modifier
//            .requiredSize(100.dp, 150.dp),
//        MenuEntityData(
//            MenuEntityDataClass(
//                "class1",
//                0
//            ),
//            true,
//            "R.drawable.profile",
//            "HappyTanuki",
//            10000,
//            true
//        )
//    )
//}