package com.my.kiosk.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.my.kiosk.Beverage

@Composable
fun PaymentDialog(
    shoppingCart: MutableState<List<MutableState<Beverage>>>,
    showDialog: MutableState<Boolean>
) {
    Dialog(onDismissRequest = {}) {
        Surface(
            modifier = Modifier
                .width(400.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(12.dp),
            color = Color.White
        ){
            var text by remember { mutableStateOf<String>("") }
            var totalPrice: Long= 0
            shoppingCart.value.forEach {data ->
                totalPrice += (data.value.price.value + data.value.optPrice) * data.value.quantity.value
            }
            TextField (
                value = text.value,
                onValueChange = {it:String ->
                    text.value = it
                },
                label = {
                    Text("결제 금액")
                }
            ){

            }
            Row{
                Button(
                    onClick = {

                    }
                ){
                    Text(text="현금")
                }
                Button(
                    onClick = {

                    }
                ){
                    Text(text="카드")
                }
            }
        }
    }
}