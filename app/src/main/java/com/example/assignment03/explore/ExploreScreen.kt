package com.example.assignment03.explore

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.assignment03.explore.bottombar.BottomNavBar
import com.example.assignment03.explore.profilecard.CardItems
import com.example.assignment03.explore.profilecard.ProfileCardList
import com.example.assignment03.explore.profilecard.cardItemsList
import com.example.assignment03.explore.tabrow.TabRow
import com.example.assignment03.ui.theme.mainColor


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    var profiles by remember { mutableStateOf(cardItemsList) }

    val filteredProfiles = profiles.filter { profile ->
        profile.name.contains(searchQuery, ignoreCase = true) ||
                profile.location.contains(searchQuery, ignoreCase = true) ||
                profile.tags.any { it.contains(searchQuery, ignoreCase = true) }
    }
    Scaffold(
        topBar = {
            TopBar(navController)
        },
        bottomBar = {
            BottomNavBar()
        }
    ) {
        Column (
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {
            ProfileCardList(navController = navController, profiles = filteredProfiles)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewExploreScreen() {
    val mockNavController = rememberNavController()
    ExploreScreen(navController = mockNavController)
}