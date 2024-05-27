package com.my.kiosk.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.my.kiosk.Beverage
import com.my.kiosk.MenuEntityData
import com.my.kiosk.MenuEntityDataClass

@Composable
fun MenuItemClickDialog(
    focusedMenuItem: MutableState<MenuEntityData>,
    shoppingcart: MutableState<List<Beverage>>,
    focusedMenuItemIcedorHot: MutableState<Boolean> = mutableStateOf(true),
    showDialog: MutableState<Boolean> = mutableStateOf(true)
) {
    var icedEnabled = remember { mutableStateOf(true) }
    var hotEnabled = remember { mutableStateOf(true) }

    Dialog(onDismissRequest = {}) {
        Surface(
            modifier = Modifier
                .width(200.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(12.dp),
            color = Color.White
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MenuEntity(
                    modifier = Modifier
                        .requiredHeight(200.dp),
                    data = focusedMenuItem.value
                )
                Row {
                    if (icedEnabled.value) {
                        Button(
                            onClick = {
                                focusedMenuItemIcedorHot.value = true
                                hotEnabled.value = false
                                icedEnabled.value = true
                            }, modifier = Modifier,
                            shape = RoundedCornerShape(24.dp)
                        ) {
                            Text("Iced")
                        }
                    }
                    else {
                        Button(
                            onClick = {
                                focusedMenuItemIcedorHot.value = true
                                icedEnabled.value = true
                                hotEnabled.value = false
                            }, modifier = Modifier,
                            shape = RoundedCornerShape(24.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.LightGray
                            )
                        ) {
                            Text("Iced")
                        }
                    }
                    if (hotEnabled.value) {
                        Button(
                            onClick = {
                                focusedMenuItemIcedorHot.value = false
                                icedEnabled.value = false
                                hotEnabled.value = true
                            }, modifier = Modifier,
                            shape = RoundedCornerShape(24.dp)
                        ) {
                            Text("Hot")
                        }
                    }
                    else {
                        Button(
                            onClick = {
                                focusedMenuItemIcedorHot.value = false
                                hotEnabled.value = true
                                icedEnabled.value = false
                            }, modifier = Modifier,
                            shape = RoundedCornerShape(24.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.LightGray
                            )
                        ) {
                            Text("Hot")
                        }
                    }
                }
                Button(
                    onClick = {
                        if ((icedEnabled.value && !hotEnabled.value) || (!icedEnabled.value && hotEnabled.value)) {
                            var temp = focusedMenuItem.value
                            temp.iced = focusedMenuItemIcedorHot.value
                            shoppingCart.value = shoppingCart.value + focusedMenuItem.value
                            showDialog.value = false
                        }
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text("장바구니에 추가", fontSize = 16.sp)
                }
            }
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun MenuItemClickDialogPreview() {
//    var _texp = remember{ mutableStateOf(
//        MenuEntityData(
//            MenuEntityDataClass(
//                "콜드브루",
//                0
//            ),
//            true,
//            "https://image.istarbucks.co.kr/upload/store/skuimg/2024/04/[9200000004544]_20240423124241716.jpg",
//            "씨솔트 카라멜 콜드 브루",
//            12457,
//            true)
//    ) }
//    MenuItemClickDialog(_texp)
//}