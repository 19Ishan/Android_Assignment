package com.example.assignment03.refine

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.assignment03.ui.theme.mainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RefineScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
            containerColor = mainColor,
            titleContentColor = Color.White,
        ),
            title = {
                Text("Refine")
            }, navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "Navigation",
                        tint = Color.White
                    )
                }
            })
    }) { innerPadding ->
        Box(modifier = Modifier.padding(23.dp)) {
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {

                AvailabilitySection()

                Spacer(modifier = Modifier.height(25.dp))

                //Status Section
                Text(
                    "Add Your Status",
                    color = mainColor,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(5.dp))

                var text by remember { mutableStateOf("Hi community! I am open to new connections '☺️'") }
                val maxCharacters = 250
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    value = text,
                    onValueChange = {
                        if (it.length <= 250) {
                            text = it
                        }
                    },
                )

                Spacer(Modifier.height(3.dp))
                Text(
                    text = "${text.length} / 250",
                    modifier = Modifier.align(Alignment.End)
                )


                Spacer(modifier = Modifier.height(10.dp))

                SliderSection()

                Spacer(modifier = Modifier.height(40.dp))

                PurposeSection()

                Spacer(modifier = Modifier.height(40.dp))

                SaveButton()
            }
        }
    }
}