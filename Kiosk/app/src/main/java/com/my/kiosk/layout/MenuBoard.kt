package com.my.kiosk.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.my.kiosk.Beverage
import com.my.kiosk.MenuEntityDataClass
import kotlinx.coroutines.launch
import kotlin.time.times

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MenuBoard(
    menuClass: List<MenuEntityDataClass>,
    menuEntityList: MutableState<List<MutableList<MutableState<Beverage>>>>,
    shoppingCart: MutableState<List<MutableState<Beverage>>>,
    transactionCompleted: MutableState<Boolean>
) {
    val pagerState = rememberPagerState(
        pageCount = { menuClass.size },
        initialPage = 0
    )
    val coroutineScope = rememberCoroutineScope()

    val showDialog = remember { mutableStateOf(false) }
    val showPaymentDialog = remember { mutableStateOf(false) }

    val showEditDialog = remember { mutableStateOf(false) }
    val focusedMenuItem = remember { mutableStateOf<Beverage?>(null) }

    if (showDialog.value)
        MenuItemClickDialog(showEditDialog, focusedMenuItem.value, shoppingCart, showDialog)
    if (showPaymentDialog.value)
        PaymentDialog(shoppingCart, showPaymentDialog, transactionCompleted)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .weight(5f),
            verticalArrangement = Arrangement.Center
        ) {
            ScrollableTabRow(
                edgePadding = 0.dp,
                selectedTabIndex = pagerState.currentPage,
                modifier = Modifier
            ) {
                menuClass.forEachIndexed { index, title ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.scrollToPage(index)
                            }
                        }
                    ) {
                        Text(
                            text = title.name,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                    }
                }
            }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.Top
            ) { page ->
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4)
                ) {
                    items(menuEntityList.value[page]) {
                        if (it.value.dataClass.id == page) {
                            MenuEntity(
                                modifier = Modifier
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = rememberRipple(bounded = true)
                                    ) {
                                        showDialog.value = true
                                        focusedMenuItem.value = it.value
                                    }
                                    .requiredHeight(200.dp),
                                data = it
                            )
                        }
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Color.Gray))
        ) {
            Text (
                text = "장바구니",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            LazyRow(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
            ) {
                items(shoppingCart.value) {
                    MenuEntity(
                        isShoppingCart = true,
                        modifier = Modifier
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(bounded = true)
                            ) {
                                showEditDialog.value = true
                                showDialog.value = true
                                focusedMenuItem.value = it.value
                              },
                        data = it
                    )
                }
            }
        }
        Button(
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                disabledContainerColor = Color.DarkGray
            ),
            modifier = Modifier
                .weight(0.7f)
                .fillMaxWidth(),
            onClick = {
                showPaymentDialog.value = true
            }
        ){
            var totalPrice: Long= 0
            shoppingCart.value.forEach {data ->
                totalPrice += ((data.value.price.value + data.value.optPrice) * data.value.quantity.value)
            }
            Text(
                color = Color.Black,
                text = "₩$totalPrice 결제하기"
            )
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun MenuPreview() {
//}