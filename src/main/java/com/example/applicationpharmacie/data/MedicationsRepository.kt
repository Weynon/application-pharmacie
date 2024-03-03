package com.example.applicationpharmacie.data

import kotlinx.coroutines.flow.Flow

interface MedicationsRepository {

    fun getAllMedicationsStream(): Flow<List<Medication>>

    suspend fun insertMedication(medication: Medication)

    suspend fun deleteMedication(medication: Medication)

    suspend fun updateMedication(medication: Medication)
}