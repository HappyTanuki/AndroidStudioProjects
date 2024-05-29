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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.my.kiosk.Beverage
import com.my.kiosk.MenuEntityData
import com.my.kiosk.MenuEntityDataClass
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MenuBoard(
    menuClass: List<MenuEntityDataClass>,
    menuEntityList: MutableState<List<MutableList<Beverage>>>,
    shoppingCart: MutableState<List<Beverage>>) {
    val pagerState = rememberPagerState(
        pageCount = { menuClass.size },
        initialPage = 0
    )
    val coroutineScope = rememberCoroutineScope()

    val showDialog = remember { mutableStateOf(false) }
    val focusedMenuItem = remember { mutableStateOf<Beverage?>(null) }

    if (showDialog.value)
        MenuItemClickDialog(focusedMenuItem, shoppingCart, showDialog)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .weight(9f),
            verticalArrangement = Arrangement.Center
        ) {
            ScrollableTabRow(
                edgePadding = 0.dp,
                selectedTabIndex = pagerState.currentPage,
                modifier = Modifier
                    .padding(0.dp, 10.dp)
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
                        if (it.dataClass.id == page) {
                            MenuEntity(
                                modifier = Modifier
                                    .clickable {
                                        showDialog.value = true
                                        focusedMenuItem.value = it
                                    }
                                    .requiredHeight(200.dp),
                                data = it
                            )
                        }
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .weight(2f)
                .border(BorderStroke(2.dp, Color.Black))
        ) {
            LazyRow(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
            ) {
                items(shoppingCart.value) {
                    MenuEntity(
                        modifier = Modifier
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(bounded = true)
                            ) {},
                        it
                    )
                }
            }
            Column(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                Button(
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red
                        ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {}
                ){
                    Text(
                        color = Color.Black,
                        text = "삭제"
                    )
                }
                Button(
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        disabledContainerColor = Color.DarkGray
                        ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {}
                ){
                    Text(
                        color = Color.Black,
                        text = "수정"
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
            onClick = {}
        ){
            var totalPrice: Long= 0
            shoppingCart.value.forEach {data ->
                totalPrice += data.price
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
//    val menuEntityDataClass = mutableListOf<MenuEntityDataClass>()
//    val _menuEntityDataClassNames = listOf<String>(
//        "페이지1",
//        "페이지2",
//        "페이지3",
//        "페이지4",
//        "페이지5",
//        "페이지6",
//        "페이지7",
//        "페이지8",
//        "페이지9",
//        "페이지10",
//    )
//    _menuEntityDataClassNames.forEachIndexed{ i, item ->
//        menuEntityDataClass.add(
//            MenuEntityDataClass(
//                item,
//                i
//            )
//        )
//    }
//    val menuEntityList: MutableState<List<MutableList<MenuEntityData>>> = remember { mutableStateOf(
//        List<MutableList<MenuEntityData>>(_menuEntityDataClassNames.size) {
//            when(it) {
//                0 ->
//                    mutableListOf<MenuEntityData>(
//                        MenuEntityData(
//                            menuEntityDataClass[0],
//                            true,
//                            "R.drawable.profile",
//                            "씨솔트 카라멜 콜드 브루",
//                            0
//                        )
//                    )
//                1 ->
//                    mutableListOf<MenuEntityData>(
//                        MenuEntityData(
//                            menuEntityDataClass[1],
//                            true,
//                            "R.drawable.profile",
//                            "시그니처 더 블랙 콜드 브루",
//                            0
//                        )
//                    )
//                else ->
//                    mutableListOf<MenuEntityData>(
//                        MenuEntityData(
//                            menuEntityDataClass[1],
//                            true,
//                            "R.drawable.profile",
//                            "시그니처 더 블랙 콜드 브루",
//                            0
//                        )
//                    )
//            }
//        }
//    )}
//
//    menuEntityList.value[0].add( MenuEntityData(
//        menuEntityDataClass[0],
//        true,
//        "R.drawable.profile",
//        "시그니처 더 블랙 콜드 브루",
//        0
//    ))
//    val shoppingcart: MutableState<List<MenuEntityData>> = remember{ mutableStateOf(
//        List(10) {
//            MenuEntityData(
//                MenuEntityDataClass(
//                    "",
//                    0
//                ),
//                true,
//                "R.drawable.profile",
//                "",
//                0
//            )
//        })
//    }
//    MenuBoard(
//        menuEntityDataClass,
//        menuEntityList,
//        shoppingcart
//    )
//}