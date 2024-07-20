package com.example.assignment03.explore.profilecard

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.assignment03.explore.SearchSection
import com.example.assignment03.ui.theme.mainColor
import com.example.assignment03.ui.theme.tabRowColor
import kotlinx.coroutines.launch

@Composable
fun ProfileCardList(navController: NavController,  profiles: List<CardItems>) {
    val profiles = remember { mutableStateOf(listOf<CardItems>()) }
    val filteredProfiles = remember { mutableStateOf(profiles.value) }
    val scope = rememberCoroutineScope()


    Column(Modifier.background(Color.White).padding(top = 110.dp)) {
        com.example.assignment03.explore.tabrow.TabRow()
        SearchSection(
            onSearch = { query ->
                scope.launch {
                    filteredProfiles.value = profiles.value.filter {
                        it.name.contains(query, ignoreCase = true) || it.location.contains(
                            query,
                            ignoreCase = true
                        ) || it.tags.any { tag -> tag.contains(query, ignoreCase = true) }
                    }
                }
            },
            onFilterClick = {

            }
        )

        LazyColumn {
            items(cardItemsList.size) { index ->
                ProfileCardItem(navController = navController, items = cardItemsList[index])
            }
        }
    }

}

//@Preview
//@Composable
//fun ProfileCardListPreview() {
//    ProfileCardList()
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCardItem(navController: NavController, items: CardItems) {
    Box(modifier = Modifier.padding(16.dp).clickable {
        navController.navigate("profile_screen/${items.profileId}")
    }) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, top = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 12.dp, top = 16.dp, end = 12.dp, bottom = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.Top
                ) {
                    Spacer(modifier = Modifier.width(40.dp)) // Space for the profile image

                    Column(Modifier.padding(start = 1.dp)) {
                        Text(
                            text = items.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = mainColor
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "${items.location} | ${items.position}",
                            color = tabRowColor,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = items.proximity, color = Color.DarkGray, fontSize = 12.sp)
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    // Invite Button
                    TextButton(
                        contentPadding = PaddingValues(0.dp),
                        onClick = { /* Handle Invite Click */ }
                    ) {
                        Text(text = "+ INVITE", color = mainColor)
                    }
                }

                Spacer(modifier = Modifier.height(5.dp))

                // Profile Score
                Row(verticalAlignment = Alignment.CenterVertically) {
                    LinearProgressIndicator(
                        strokeCap = StrokeCap.Round,
                        progress = { 0.32f },
                        modifier = Modifier
                            .width(109.dp)
                            .padding(start = 41.dp),
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(
                        text = "Profile Score - ${(items.profileScore * 100).toInt()}%",
                        color = Color.Gray,
                        fontSize = 10.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                val tagChunks = items.tags.chunked(3) // Chunk tags into sublists of 3
                tagChunks.forEach { chunk ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        chunk.forEach { tag ->
                            ProfileTag(tag)
                            Spacer(modifier = Modifier.width(4.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                }


                Spacer(modifier = Modifier.height(8.dp))

                // Status
                Text(
                    text = items.status,
                    fontWeight = FontWeight.SemiBold,
                    color = tabRowColor,
                    fontSize = 11.sp,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Description
                items.bio?.let {
                    Text(
                        text = it,
                        color = tabRowColor,
                        fontSize = 12.sp
                    )
                }
            }
        }

        // Profile Image
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Gray, shape = RoundedCornerShape(10.dp))
                .align(Alignment.TopStart),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = items.profileName,
                color = mainColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp
            )
        }
    }
}

@Composable
fun ProfileTag(tag: String) {
    Surface(
        shape = RoundedCornerShape(16.dp),
//        color = Color(0xFFE0E0E0), // Light gray background color
        modifier = Modifier.padding(end = 4.dp)
    ) {
        Text(
            text = tag,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            color = Color.DarkGray,
            fontSize = 12.sp
        )
    }
}

fun getInitials(fullName: String): String {
    val name = fullName.split(" ");
    return if (name.size >= 2) {
        "${name[0].first()}${name[1].first()}"
    } else {
        fullName.take(2)
    }.uppercase()
}