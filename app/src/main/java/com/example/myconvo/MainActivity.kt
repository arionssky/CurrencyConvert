package com.example.myconvo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myconvo.uii.ConversionPage
import com.example.myconvo.uii.CurrencyExchangeRatesPage
import com.example.myconvo.ui.theme.MyConvoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyConvoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CurrencyConverterApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CurrencyConverterApp(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()

    Surface {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                CurrencyExchangeRatesPage(navController)
            }
            composable("convert/{currencyCode}") { backStackEntry ->
                val currencyCode = backStackEntry.arguments?.getString("currencyCode") ?: "USD"
                ConversionPage(navController, currencyCode)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyConvoTheme {
        CurrencyConverterApp()
    }
}