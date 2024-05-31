package com.my.kiosk.layout

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.room.util.copy
import com.my.kiosk.Beverage
import com.my.kiosk.BeverageAddIce
import com.my.kiosk.BeverageAddPurl
import com.my.kiosk.BeverageAddShot
import com.my.kiosk.Coffee
import com.my.kiosk.HotBeverage
import com.my.kiosk.MenuEntityDataClass
import com.my.kiosk.beverageDecoratorRemover
import com.my.kiosk.beverageDecoratorTypegetter
import com.my.kiosk.searchBeverageDecorator

@SuppressLint("UnrememberedMutableState")
@Composable
fun MenuItemClickDialog(
    focusedItem: Beverage,
    shoppingCart: MutableList<Beverage>,
    showDialog: MutableState<Boolean>
) {
    val icedEnabled = remember { mutableStateOf(true) }
    val hotEnabled = remember { mutableStateOf(true) }
    val shotEnabled = remember { mutableStateOf(false) }
    val purlEnabled = remember { mutableStateOf(false) }

    var itemToAdd: Beverage
    when (beverageDecoratorTypegetter(focusedItem)) {
        else ->
            itemToAdd = Coffee (
                dataClass = focusedItem.dataClass,
                imgURL = focusedItem.imgURL,
                name = focusedItem.name,
                quantity = mutableIntStateOf(1),
                price = focusedItem.price
            )
    }

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
                    data = mutableStateOf(itemToAdd)
                )
                if (!shotEnabled.value) {
                    Button(
                        onClick = {
                            itemToAdd = BeverageAddShot(itemToAdd)
                            shotEnabled.value = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.LightGray
                        )
                    ) {
                        Text("샷 추가")
                    }
                }
                else {
                    Button(
                        onClick = {
                            itemToAdd = beverageDecoratorRemover(itemToAdd, BeverageAddShot(itemToAdd))
                            shotEnabled.value = false
                        }
                    ) {
                        Text("샷 추가")
                    }
                }
                if (!purlEnabled.value) {
                    Button(
                        onClick = {
                            itemToAdd = BeverageAddPurl(itemToAdd)
                            purlEnabled.value = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.LightGray
                        )
                    ) {
                        Text("펄 추가")
                    }
                }
                else {
                    Button(
                        onClick = {
                            itemToAdd = beverageDecoratorRemover(itemToAdd, BeverageAddPurl(itemToAdd))
                            purlEnabled.value = false
                        }
                    ) {
                        Text("펄 추가")
                    }
                }
                Row {
                    if (icedEnabled.value) {
                        Button(
                            onClick = {
                                itemToAdd = BeverageAddIce(beverageDecoratorRemover(itemToAdd, HotBeverage(itemToAdd)))
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
                                itemToAdd = BeverageAddIce(beverageDecoratorRemover(itemToAdd, HotBeverage(itemToAdd)))
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
                                itemToAdd = HotBeverage(beverageDecoratorRemover(itemToAdd, BeverageAddIce(itemToAdd)))
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
                                itemToAdd = HotBeverage(beverageDecoratorRemover(itemToAdd, BeverageAddIce(itemToAdd)))
                                hotEnabled.value = true
                                icedEnabled.value = false
                            },
                            shape = RoundedCornerShape(24.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.LightGray
                            )
                        ) {
                            Text("Hot")
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .requiredHeight(40.dp)
                ) {
                    Button(
                        onClick = {
                            if (itemToAdd.quantity.value <= 1)
                                return@Button
                            itemToAdd.quantity.value -= 1
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
                            text = "${itemToAdd.quantity.value}",
                            textAlign = TextAlign.Center
                        )
                    }
                    Button(
                        onClick = {
                            itemToAdd.quantity.value += 1
                        }
                    ){
                        Text(text = ">")}
                    }
                Button(
                    onClick = {
                        if ((icedEnabled.value && !hotEnabled.value) || (!icedEnabled.value && hotEnabled.value)) {
                            val item = shoppingCart.find {
                                it.imgURL == itemToAdd.imgURL && it.options == itemToAdd.options
                            }
                            shoppingCart += itemToAdd
                            showDialog.value = false
                        }
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text("장바구니에 추가", fontSize = 16.sp)
                }
                if(!((icedEnabled.value && !hotEnabled.value) || (!icedEnabled.value && hotEnabled.value))) {
                    Text("핫 또는 아이스를 선택해주세요", fontSize = 16.sp)
                }
            }
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun MenuItemClickDialogPreview() {
//}