package com.my.kiosk.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.my.kiosk.MenuEntityDataClass
import com.my.kiosk.R
import com.valentinilk.shimmer.shimmer

@Composable
fun LoadingEntity(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    entity: @Composable () -> Unit) {
    if (isLoading) {
        Box(
            modifier = modifier
                .padding(5.dp, 5.dp, 5.dp, 5.dp)
                .background(Color.Gray)
                .shimmer()
                .fillMaxSize()
        )
    } else {
        entity()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun LoadingEntityPreview() {
//    MenuEntity( data = MenuEntityData(
//        MenuEntityDataClass(
//            "class1",
//            0
//        ),
//        false,
//        "R.drawable.profile",
//        "HappyTanuki",
//        10000,
//        true,)
//    )
//}