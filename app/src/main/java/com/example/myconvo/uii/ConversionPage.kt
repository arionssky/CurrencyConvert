package com.example.myconvo.uii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ConversionPage(navController: NavController, currencyCode: String) {

    var inputAmount by remember { mutableStateOf("") }
    var convertedAmount by remember { mutableStateOf(0.0) }
    var isError by remember { mutableStateOf(false) }

    val conversionRate = getConversionRate(currencyCode)

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = currencyCode,
            style = TextStyle(fontSize = 24.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold),
            modifier = Modifier.padding(8.dp)
        )

        OutlinedTextField(
            value = inputAmount,
            onValueChange = { value ->
                isError = value.toDoubleOrNull() == null && value.isNotEmpty()
                inputAmount = value
            },
            label = { Text("Enter amount in $currencyCode") },
            isError = isError,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number), // Fixing KeyboardType
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        if (isError) {
            Text(
                text = "Please enter a valid number",
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (!isError && inputAmount.isNotEmpty()) {
                val amount = inputAmount.toDoubleOrNull() ?: 0.0
                convertedAmount = amount * conversionRate
            }
        }) {
            Text(text = "Хөрвүүлэх")
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (convertedAmount > 0) {
            Text(
                text = String.format("%.2f MNT", convertedAmount),
                style = TextStyle(fontSize = 24.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold),
                modifier = Modifier.padding(8.dp)
            )

            Text(
                text = "🇲🇳",
                fontSize = 48.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

fun getConversionRate(currencyCode: String): Double {
    return when (currencyCode) {
        "EUR" -> 3700.0
        "GBP" -> 4200.0
        "RUB" -> 50.0
        "CNY" -> 520.0
        "JPY" -> 35.0
        "KRW" -> 3.0
        "AUD" -> 2800.0
        "CHF" -> 4000.0
        "CAD" -> 2900.0
        "SGD" -> 2600.0
        "SEK" -> 350.0
        "TRY" -> 150.0
        "HKD" -> 480.0
        else -> 0.0
    }
}