package com.example.assignment03

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.assignment03.explore.ExploreScreen
import com.example.assignment03.explore.ProfileScreen
import com.example.assignment03.explore.profilecard.cardItemsList
import com.example.assignment03.refine.RefineScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "explore") {
        composable("explore") {
            ExploreScreen(navController)
        }
        composable("refine") {
            RefineScreen(navController)
        }
        composable("explore_screen") {
            ExploreScreen(navController = navController)
        }
        composable("profile_screen/{profileId}") { backStackEntry ->
            val profileId = backStackEntry.arguments?.getString("profileId")
            val cardItems = cardItemsList.first { it.profileId == profileId }
            ProfileScreen(navController = navController, cardItems = cardItems)
        }
    }
}