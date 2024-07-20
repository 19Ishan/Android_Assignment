package com.example.assignment03.explore.tabrow

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment03.ui.theme.tabRowColor

val items = listOf(
    TabItem(title = "Personal"),
    TabItem(title = "Services"),
    TabItem(title = "Business")
)

@Preview
@Composable
fun TabRowPreview(){
    TabRow()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRow() {
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        items.size
    }

    LaunchedEffect(key1 = selectedIndex) {
        pagerState.animateScrollToPage(selectedIndex)
    }

    LaunchedEffect(key1 = pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedIndex = pagerState.currentPage
        }
    }

    Column(Modifier.height(50.dp)) {
        TabRow(
            selectedTabIndex = selectedIndex,
            containerColor = tabRowColor,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex]),
                    color = Color.White
                )
            },
            modifier = Modifier.height(90.dp)
        ) {
            items.forEachIndexed { index, item ->
                Tab(
                    modifier = Modifier.padding(17.dp),
                    selected = index == selectedIndex,
                    onClick = {
                        selectedIndex = index
                    }
                ) {
                    Text(
                        text = item.title,
                        color = if (selectedIndex == index) {
                            Color.White
                        } else {
                            Color.Gray
                        }
                    )
                }
            }
        }

    }

}