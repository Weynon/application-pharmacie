package com.example.applicationpharmacie.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "medicaments")
data class Medication (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val type: String,
    val expirationDate: String
)