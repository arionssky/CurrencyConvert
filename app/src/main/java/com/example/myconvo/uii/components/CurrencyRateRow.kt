package com.example.myconvo.uii.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CurrencyRateRow(flagEmoji: String, currencyName: String, currencyCode: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = flagEmoji,
            modifier = Modifier.padding(end = 8.dp),
            fontSize = 24.sp
        )
        Text(
            text = currencyName,
            modifier = Modifier.weight(1f),
            fontSize = 18.sp
        )
        Text(
            text = currencyCode,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
