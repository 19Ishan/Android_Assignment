package com.example.assignment03.explore.bottombar

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.GroupWork
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.PeopleAlt
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.assignment03.ui.theme.mainColor

val items = listOf(
    BottomNavigation(
        title = "Explore",
        icon = Icons.Default.RemoveRedEye
    ),
    BottomNavigation(
        title = "Connections",
        icon = Icons.Default.GroupWork
    ),
    BottomNavigation(
        title = "Chat",
        icon = Icons.AutoMirrored.Filled.Chat
    ),
    BottomNavigation(
        title = "Contacts",
        icon = Icons.Default.Contacts
    ),
    BottomNavigation(
        title = "Groups",
        icon = Icons.Default.Groups
    )
)

@Preview
@Composable
fun BottomNavBar() {
    var selectedItem by remember { mutableIntStateOf(0) }

    NavigationBar {
        Row {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItem == index,
                    onClick = { selectedItem == index },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = if (selectedItem == index) {
                                mainColor
                            } else {
                                Color.Black
                            }
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontSize = 11.sp
                        )
                    }
                )
            }
        }
    }
}