package com.my.kiosk.layout

import android.annotation.SuppressLint
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
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.my.kiosk.Beverage
import com.my.kiosk.BeverageAddIce
import com.my.kiosk.BeverageAddPurl
import com.my.kiosk.BeverageAddShot
import com.my.kiosk.Coffee
import com.my.kiosk.HotBeverage
import com.my.kiosk.MenuEntityDataClass
import com.my.kiosk.beverageDecoratorRemover
import com.my.kiosk.searchBeverageDecorator

@SuppressLint("UnrememberedMutableState")
@Composable
fun MenuItemClickDialog(
    edit: MutableState<Boolean>,
    focusedItem: Beverage?,
    shoppingCart: MutableState<List<MutableState<Beverage>>>,
    showDialog: MutableState<Boolean>
) {
    val icedEnabled = remember { mutableStateOf(true) }
    val hotEnabled = remember { mutableStateOf(true) }
    val shotEnabled = remember { mutableStateOf(false) }
    val purlEnabled = remember { mutableStateOf(false) }

    val addItemQuantity: MutableIntState

    var itemToAdd: MutableState<Beverage>

    if (edit.value) {
        itemToAdd = mutableStateOf(focusedItem!!)
        if(searchBeverageDecorator(focusedItem, BeverageAddIce(focusedItem)) == null) {
            icedEnabled.value = true
            hotEnabled.value = false
        }
        else {
            icedEnabled.value = false
            hotEnabled.value = true
        }
        addItemQuantity = remember { mutableIntStateOf(focusedItem!!.quantity.value) }
        itemToAdd.value.quantity = addItemQuantity
    }
    else {
        itemToAdd = mutableStateOf(focusedItem!!.clone())
        addItemQuantity = remember { mutableIntStateOf(1) }
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
                    data = itemToAdd
                )
                if (!shotEnabled.value) {
                    Button(
                        onClick = {
                            itemToAdd.value = BeverageAddShot(itemToAdd.value)
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
                            itemToAdd.value = beverageDecoratorRemover(itemToAdd.value, BeverageAddShot(itemToAdd.value))
                            shotEnabled.value = false
                        }
                    ) {
                        Text("샷 추가")
                    }
                }
                if (!purlEnabled.value) {
                    Button(
                        onClick = {
                            itemToAdd.value = BeverageAddPurl(itemToAdd.value)
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
                            itemToAdd.value = beverageDecoratorRemover(itemToAdd.value, BeverageAddPurl(itemToAdd.value))
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
                                itemToAdd.value = BeverageAddIce(beverageDecoratorRemover(itemToAdd.value, HotBeverage(itemToAdd.value)))
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
                                itemToAdd.value = BeverageAddIce(beverageDecoratorRemover(itemToAdd.value, HotBeverage(itemToAdd.value)))
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
                                itemToAdd.value = HotBeverage(beverageDecoratorRemover(itemToAdd.value, BeverageAddIce(itemToAdd.value)))
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
                                itemToAdd.value = HotBeverage(beverageDecoratorRemover(itemToAdd.value, BeverageAddIce(itemToAdd.value)))
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
                Row {
                    Button(
                        onClick = {
                            if (itemToAdd.value.quantity.value <= 0)
                                return@Button
                            itemToAdd.value.quantity.value -= 1
                        }
                    ){
                        Text(text = "<")
                    }
                    Text(text = "${itemToAdd.value.quantity.value}")
                    Button(
                        onClick = {
                            itemToAdd.value.quantity.value += 1
                        }
                    ){
                        Text(text = ">")}
                    }
                Button(
                    onClick = {
                        if (edit.value) {
                            if ((icedEnabled.value && !hotEnabled.value) || (!icedEnabled.value && hotEnabled.value)) {
                                val item = shoppingCart.value.find {
                                    it.value.imgURL == itemToAdd.value.imgURL
                                }
                                if (item != null) {
                                    item.value = itemToAdd.value
                                    showDialog.value = false
                                }
                            }
                            edit.value = false
                        }
                        else {
                            if ((icedEnabled.value && !hotEnabled.value) || (!icedEnabled.value && hotEnabled.value)) {
                                val item = shoppingCart.value.find {
                                    it.value.imgURL == itemToAdd.value.imgURL && it.value.options == itemToAdd.value.options
                                }
                                if (item != null)
                                    item.value.quantity.value += 1
                                else {
                                    shoppingCart.value += mutableStateOf<Beverage>(itemToAdd.value)
                                }
                                showDialog.value = false
                            }
                        }
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    if (edit.value) {
                        Text("정정", fontSize = 16.sp)
                    }
                    else {
                        Text("장바구니에 추가", fontSize = 16.sp)
                    }
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