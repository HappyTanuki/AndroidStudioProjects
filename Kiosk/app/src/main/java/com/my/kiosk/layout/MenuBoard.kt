package com.my.kiosk.layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.my.kiosk.MenuEntityData
import com.my.kiosk.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
class MenuBoard {
    private lateinit var pagerState : PagerState
    private lateinit var coroutineScope: CoroutineScope

    @Composable
    operator fun invoke() {
        val pages = listOf("페이지1", "페이지2", "페이지3")
        val it0 = MenuEntity()

        pagerState = rememberPagerState(
            pageCount = { pages.size },
            initialPage = 0
        )
        coroutineScope = rememberCoroutineScope()

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            TabRow(
                selectedTabIndex = pagerState.currentPage
            ) {
                pages.forEachIndexed { index, title ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.scrollToPage(index)
                            }
                        }
                    ){
                        Text(text = title,
                            modifier = Modifier
                                .padding(10.dp))
                    }
                }

            }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
            ) {page ->
                LoadingEntity(false) {
                    LazyColumn(){
                        items(
                            count = 1000000,
                            itemContent = {
                                it0(MenuEntityData(
                                    R.drawable.profile,
                                    "HappyTanuki",
                                    it
                                ))
                            }
                        )
                    }
//                    Text(
//                        text = "Page: $page",
//                        modifier = Modifier.wrapContentSize()
//                    )
                }
            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        this()
    }
}