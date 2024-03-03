package com.example.applicationpharmacie.data

import java.time.LocalDate
import java.util.Date

data class MedicationUiState(
    val name: String = "",
    val description: String = "",
    val type: String = "",
    val expirationDate: LocalDate = LocalDate.parse("2011-11-11")
) {
    override fun toString(): String {
        return "MedicationUiState(name='$name', description='$description', type='$type', expirationDate=$expirationDate)"
    }
}
