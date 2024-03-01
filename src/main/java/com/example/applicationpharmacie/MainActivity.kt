package com.example.applicationpharmacie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.applicationpharmacie.ui.theme.ApplicationPharmacieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationPharmacieTheme {
                PharmacieApp()
            }
        }
    }
}