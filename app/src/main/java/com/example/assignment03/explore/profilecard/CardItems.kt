package com.example.assignment03.explore.profilecard

import androidx.compose.ui.graphics.vector.ImageVector

data class CardItems(
    val profileId: String,
    val name: String,
    val profileName: String,
    val location: String,
    val position: String,
    val proximity: String,
    val profileScore: Float,
    val status: String,
    val bio: String?,
    val tags: List<String>
)
