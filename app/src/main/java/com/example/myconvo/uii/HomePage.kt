package com.example.myconvo.uii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myconvo.uii.components.CurrencyRateRow

@Composable
fun CurrencyExchangeRatesPage(navController: NavController) {

    val exchangeRates = listOf(
        Pair("🇪🇺", "Евро" to "EUR"),
        Pair("🇬🇧", "Английн фунт" to "GBP"),
        Pair("🇷🇺", "Оросын рубль" to "RUB"),
        Pair("🇨🇳", "Хятадын юань" to "CNY"),
        Pair("🇯🇵", "Японы иен" to "JPY"),
        Pair("🇰🇷", "БНСУ-ын вон" to "KRW"),
        Pair("🇦🇺", "Австрали доллар" to "AUD"),
        Pair("🇨🇭", "Швейцар франк" to "CHF"),
        Pair("🇨🇦", "Канад доллар" to "CAD"),
        Pair("🇸🇬", "Сингапур доллар" to "SGD"),
        Pair("🇸🇪", "Швед крон" to "SEK"),
        Pair("🇹🇷", "Туркийн Лир" to "TRY"),
        Pair("🇭🇰", "Гонконг доллар" to "HKD")
    )

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (rate in exchangeRates) {
            CurrencyRateRow(flagEmoji = rate.first, currencyName = rate.second.first, currencyCode = rate.second.second) {
                navController.navigate("convert/${rate.second.second}")
            }
        }
    }
}