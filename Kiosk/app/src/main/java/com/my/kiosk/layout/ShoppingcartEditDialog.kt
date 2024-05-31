package com.my.kiosk.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.my.kiosk.Beverage
import com.my.kiosk.BeverageAddIce
import com.my.kiosk.BeverageAddPurl
import com.my.kiosk.BeverageAddShot
import com.my.kiosk.HotBeverage
import com.my.kiosk.beverageDecoratorRemover
import com.my.kiosk.searchBeverageDecorator

@Composable
fun ShoppingcartEditDialog(
    focusedItem: MutableState<Beverage>,
    shoppingCart: MutableList<Beverage>,
    showDialog: MutableState<Boolean>
) {
    var iceBtnColor by remember { mutableStateOf( Color.Blue ) }
    var hotBtnColor by remember { mutableStateOf( Color.Blue ) }
    var shotBtnColor by remember { mutableStateOf( Color.Blue ) }
    var purlBtnColor by remember { mutableStateOf( Color.Blue ) }

    if (searchBeverageDecorator(focusedItem.value, BeverageAddIce(focusedItem.value)) != null)
        iceBtnColor = Color.LightGray
    else
        hotBtnColor = Color.LightGray

    if (searchBeverageDecorator(focusedItem.value, BeverageAddPurl(focusedItem.value)) != null)
        purlBtnColor = Color.LightGray

    if (searchBeverageDecorator(focusedItem.value, BeverageAddShot(focusedItem.value)) != null)
        shotBtnColor = Color.LightGray

    Dialog(onDismissRequest = {}) {
        Surface(
            modifier = Modifier
                .width(300.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(12.dp),
            color = Color.White
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MenuEntity(
                    isShoppingCart = true,
                    modifier = Modifier
                        .requiredHeight(200.dp),
                    data = focusedItem
                )
                Button(
                    onClick = {
                        if (shotBtnColor == Color.LightGray) {
                            shotBtnColor = Color.Blue
                            focusedItem.value = BeverageAddShot(focusedItem.value)
                        }
                        else {
                            shotBtnColor = Color.LightGray
                            focusedItem.value = beverageDecoratorRemover(
                                focusedItem.value,
                                BeverageAddShot(focusedItem.value)
                            )
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = shotBtnColor
                    )
                ) {
                    Text("샷 추가")
                }
                Button(
                    onClick = {
                        if (purlBtnColor == Color.LightGray) {
                            purlBtnColor = Color.Blue
                            focusedItem.value = BeverageAddPurl(focusedItem.value)
                        }
                        else {
                            purlBtnColor = Color.LightGray
                            focusedItem.value = beverageDecoratorRemover(
                                focusedItem.value,
                                BeverageAddPurl(focusedItem.value)
                            )
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = purlBtnColor
                    )
                ) {
                    Text("펄 추가")
                }
                Row {
                    Button(
                        onClick = {
                            if (iceBtnColor == Color.LightGray) {
                                iceBtnColor = Color.Blue
                                hotBtnColor = Color.LightGray
                                focusedItem.value = beverageDecoratorRemover(
                                    focusedItem.value,
                                    HotBeverage(focusedItem.value)
                                )
                                focusedItem.value = beverageDecoratorRemover(
                                    focusedItem.value,
                                    BeverageAddIce(focusedItem.value)
                                )
                                focusedItem.value = BeverageAddIce(focusedItem.value)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = iceBtnColor
                        )
                    ) {
                        Text("Iced")
                    }
                    Button(
                        onClick = {
                            if (hotBtnColor == Color.LightGray) {
                                hotBtnColor = Color.Blue
                                iceBtnColor = Color.LightGray
                                focusedItem.value = beverageDecoratorRemover(
                                    focusedItem.value,
                                    HotBeverage(focusedItem.value)
                                )
                                focusedItem.value = beverageDecoratorRemover(
                                    focusedItem.value,
                                    BeverageAddIce(focusedItem.value)
                                )
                                focusedItem.value = HotBeverage(focusedItem.value)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = hotBtnColor
                        )
                    ) {
                        Text("Hot")
                    }
                }
                Row(
                    modifier = Modifier
                        .requiredHeight(40.dp)
                ) {
                    Button(
                        onClick = {
                            if (focusedItem.value.quantity.value <= 1)
                                return@Button
                            focusedItem.value.quantity.value -= 1
                        }
                    ){
                        Text(text = "<")
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .requiredWidth(40.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "${focusedItem.value.quantity.value}",
                            textAlign = TextAlign.Center
                        )
                    }
                    Button(
                        onClick = {
                            focusedItem.value.quantity.value += 1
                        }
                    ){
                        Text(text = ">")
                    }
                }
                Button(
                    onClick = {
                        showDialog.value = false
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text("정정", fontSize = 16.sp)
                }
                Button(
                    onClick = {
                        val item = shoppingCart.find {
                            it == focusedItem.value
                        }
                        shoppingCart.remove(item)
                        showDialog.value = false
                    }
                ) {
                    Text("삭제")
                }
            }
        }
    }
}