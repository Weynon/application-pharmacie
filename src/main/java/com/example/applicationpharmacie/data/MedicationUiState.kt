package com.example.applicationpharmacie.data

import java.util.Date

data class MedicationUiState(
    val name: String = "",
    val description: String = "",
    val type: String = "",
    val expirationDate: Date = Date()
) {
    override fun toString(): String {
        return "MedicationUiState(name='$name', description='$description', type='$type', expirationDate=$expirationDate)"
    }
}
