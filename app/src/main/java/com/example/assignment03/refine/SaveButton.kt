package com.example.assignment03.refine

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.assignment03.ui.theme.mainColor

@Composable
fun SaveButton() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonColors(
            containerColor = mainColor,
            contentColor = Color.White,
            disabledContentColor = Color.White,
            disabledContainerColor = mainColor
        )
    ) {
        Text(text = "Save And Explore")
    }
}