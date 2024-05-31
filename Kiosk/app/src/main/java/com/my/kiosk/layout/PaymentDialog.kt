package com.my.kiosk.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.my.kiosk.Beverage

@Composable
fun PaymentDialog(
    shoppingCart: MutableList<Beverage>,
    showDialog: MutableState<Boolean>,
    transactionCompleted: MutableState<Boolean>
) {
    var constTotalValue: Int = 0
    shoppingCart.forEach { data ->
        constTotalValue += (data.price.value + data.optPrice) * data.quantity.value
    }
    Dialog(onDismissRequest = {}) {
        Surface(
            modifier = Modifier
                .width(400.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(12.dp),
            color = Color.White
        ){
            val totalPrice by remember { mutableStateOf(constTotalValue) }
            var purchasedValue by remember { mutableStateOf(0) }

            var remainValue by remember { mutableStateOf(totalPrice) }
            var inputString by remember { mutableStateOf<String>(totalPrice.toString()) }
            Column {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "결제",
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = remainValue.toString(),
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "결제수단 선택",
                    textAlign = TextAlign.Center
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = inputString,
                    onValueChange = {
                        if (it.toInt() > remainValue) {
                            inputString = remainValue.toString()
                        }
                        else {
                            inputString = it
                        }
                    },
                    label = {
                        Text("결제할 금액")
                    }
                )
                Row {
                    Button(
                        modifier = Modifier
                            .weight(1f),
                        onClick = {
                            purchasedValue += inputString.toInt()
                            if (totalPrice - purchasedValue <= 0) {
                                transactionCompleted.value = !transactionCompleted.value
                                showDialog.value = false
                            }
                            else {
                                remainValue = totalPrice - purchasedValue
                                if (inputString.toInt() > remainValue) {
                                    inputString = remainValue.toString()
                                }
                            }
                        }
                    ) {
                        Text(text = "현금")
                    }
                    Button(
                        modifier = Modifier
                            .weight(1f),
                        onClick = {
                            purchasedValue += inputString.toInt()
                            if (totalPrice - purchasedValue <= 0) {
                                transactionCompleted.value = !transactionCompleted.value
                                showDialog.value = false
                            }
                            else {
                                remainValue = totalPrice - purchasedValue
                                if (inputString.toInt() > remainValue) {
                                    inputString = remainValue.toString()
                                }
                            }
                        }
                    ) {
                        Text(text = "카드")
                    }
                }
            }
        }
    }
}