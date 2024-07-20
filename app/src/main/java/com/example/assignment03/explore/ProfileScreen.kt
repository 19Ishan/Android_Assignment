package com.example.assignment03.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ConnectedTv
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Pix
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.assignment03.explore.profilecard.CardItems
import com.example.assignment03.explore.profilecard.cardItemsList
import com.example.assignment03.ui.theme.mainColor


@Composable
fun ProfileScreen(navController: NavController, cardItems: CardItems) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mainColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 50.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }

                Spacer(modifier = Modifier.weight(1f))

                TextButton(
                    onClick = { /* Handle Invite Click */ },
                    modifier = Modifier
                        .background(mainColor, shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(text = "+ INVITE", color = Color.White)
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .background(Color.Gray, shape = RoundedCornerShape(40.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = cardItems.profileName,
                            color = mainColor,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 30.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = cardItems.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = mainColor
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Male",
                            fontSize = 16.sp,
                            color = Color.Gray
                        ) // Assuming gender, can be dynamic
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "${cardItems.location}, India",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    }
                }

                LinearProgressIndicator(
                    progress = cardItems.profileScore,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .padding(vertical = 16.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { /* Handle LinkedIn Click */ }) {
                        Icon(imageVector = Icons.Default.ConnectedTv, contentDescription = "LinkedIn")
                    }
                    IconButton(onClick = { /* Handle Xing Click */ }) {
                        Icon(imageVector = Icons.Default.Pix, contentDescription = "Xing")
                    }
                    IconButton(onClick = { /* Handle Instagram Click */ }) {
                        Icon(imageVector = Icons.Default.Image, contentDescription = "Instagram")
                    }
                    IconButton(onClick = { /* Handle Facebook Click */ }) {
                        Icon(imageVector = Icons.Default.Facebook, contentDescription = "Facebook")
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { /* Handle Call Click */ },
                        colors = ButtonDefaults.buttonColors(mainColor)
                    ) {
                        Text(text = "Call", color = Color.White)
                    }
                    Button(
                        onClick = { /* Handle Chat Click */ },
                        colors = ButtonDefaults.buttonColors(mainColor)
                    ) {
                        Text(text = "Chat", color = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                TabRow(
                    selectedTabIndex = 0,
                    contentColor = mainColor,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Tab(
                        selected = true,
                        onClick = { /* Handle About Tab Click */ }
                    ) {
                        Text(text = "About", modifier = Modifier.padding(16.dp))
                    }
                    Tab(
                        selected = false,
                        onClick = { /* Handle Activities Tab Click */ }
                    ) {
                        Text(text = "Activities", modifier = Modifier.padding(16.dp))
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = cardItems.bio ?: "No bio available",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(16.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = cardItems.location, fontSize = 16.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = cardItems.position, fontSize = 16.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Netclan ID: ${cardItems.profileName}",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Contact",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = mainColor
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Personal Email: example@gmail.com",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Personal Phone: Masked", fontSize = 16.sp, color = Color.Gray)
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    val sampleCardItem = cardItemsList.first()
    val mockNavController = rememberNavController()
    ProfileScreen(navController = mockNavController, cardItems = sampleCardItem)
}

