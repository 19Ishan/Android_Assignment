package com.example.assignment03.refine

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment03.ui.theme.mainColor

@Preview
@Composable
fun PurposeSection() {
    val purposeList1 = listOf(
        "Coffee",
        "Business",
        "Hobbies",
        "Friendship"
    )

    val purposeList2 = listOf(
        "Movies",
        "Dinning",
        "Dating",
        "Matrimony"
    )

    var selectedItems = remember { mutableStateListOf<String>("") }

    Column () {
        Text(
            text = "Select Purpose",
            color = mainColor,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            purposeList1.forEach { it ->
                Chip(
                    title = it,
                    selectedItems = selectedItems,
                    onSelected = { selectedTitle ->
                        if (selectedItems.contains(selectedTitle)) {
                            selectedItems.remove(selectedTitle)
                        } else {
                            selectedItems.add(selectedTitle)
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            purposeList2.forEach { it ->
                Chip(
                    title = it,
                    selectedItems = selectedItems,
                    onSelected = { selectedTitle ->
                        if (selectedItems.contains(selectedTitle)) {
                            selectedItems.remove(selectedTitle)
                        } else {
                            selectedItems.add(selectedTitle)
                        }
                    }
                )
            }
        }
    }

}

@Composable
fun Chip(
    title: String,
    selectedItems: List<String>,
    onSelected: (String) -> Unit
) {
    var isSelected = selectedItems.contains(title)

    val background = if (isSelected) mainColor else Color.White
    val contentColor = if (isSelected) Color.White else Color.Black
    val borderColor = mainColor

    Box(
        modifier = Modifier
            .padding(end = 5.dp)
            .height(35.dp)
            .clip(RoundedCornerShape(15.dp))
            .border(2.dp, borderColor, RoundedCornerShape(15.dp))
            .background(background)
            .clickable {
                onSelected(title)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = title,
            color = contentColor,
            fontSize = 14.sp
        )
    }
}
