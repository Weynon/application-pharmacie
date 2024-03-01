package com.example.applicationpharmacie.data

import java.util.Date

data class MedicationUiState(
    val name: String = "",
    val description: String = "",
    val type: String = "",
    val expirationDate: Date = Date(),
)
