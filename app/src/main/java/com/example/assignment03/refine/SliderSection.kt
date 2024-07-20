package com.example.assignment03.refine

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.assignment03.ui.theme.mainColor

@Composable
fun SliderSection() {
    Text(
        "Select Hyper Local Distance",
        color = mainColor,
        fontWeight = FontWeight.SemiBold
    )

    Spacer(modifier = Modifier.height(40.dp))

    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Slider(
        value = sliderPosition,
        onValueChange =  { sliderPosition = it },
        valueRange = 1f..100f,
        colors = SliderDefaults.colors(
            activeTrackColor = mainColor,
            thumbColor = mainColor
        )
    )

    Row() {
        Text(
            text = "1Km",
            color = mainColor
        )
        Spacer(modifier = Modifier.width(270.dp))
        Text(
            text = "100Km",
            color = mainColor
        )
    }
}