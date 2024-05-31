package com.my.kiosk.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.my.kiosk.R

@Composable
fun DelivaryOrStoreSelectSplash(
    showOrdertypeSelectionScreen: MutableState<Boolean>
) {
    Dialog(
        properties = DialogProperties(usePlatformDefaultWidth = false),
        onDismissRequest = {}
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            shape = RoundedCornerShape(12.dp),
            color = Color.White
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier)
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .requiredSize(110.dp)
                            .paint(
                                painterResource(id = R.drawable.logo),
                                contentScale = ContentScale.FillBounds
                            )
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "주문 유형 선택",
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Button(
                        onClick = {
                            showOrdertypeSelectionScreen.value = false
                        }
                    ) {
                        Text(text = "매장")
                    }
                    Spacer(
                        modifier = Modifier
                            .requiredWidth(30.dp)
                    )
                    Button(
                        onClick = {
                            showOrdertypeSelectionScreen.value = false
                        }
                    ) {
                        Text(text = "포장")
                    }
                }
            }
        }
    }
}