package com.example.assignment03.refine

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment03.ui.theme.mainColor

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvailabilitySection() {
    val availabilityStatus = listOf(
        "Available | Hey Let Us Connect",
        "Away | Stay Discrete And Watch",
        "Busy | Do Not Disturb | Will Catch Up Later",
        "SOS | Emergency! Need Assistance! HELP"
    )

    var isExpanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(availabilityStatus[0]) }

    Text(
        "Select Your Availability",
        color = mainColor,
        fontWeight = FontWeight.SemiBold
    )

    Spacer(Modifier.height(5.dp))

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = !isExpanded }) {
        TextField(
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            value = selectedOptionText,
            onValueChange = { },
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = isExpanded
                )
            }
        )

        DropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            availabilityStatus.forEachIndexed { index, text ->
                DropdownMenuItem(
                    text = { Text(text = text) },
                    onClick = {
                        selectedOptionText = availabilityStatus[index]
                        isExpanded = false
                    }
                )
            }
        }
    }
}