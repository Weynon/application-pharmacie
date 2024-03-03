package com.example.applicationpharmacie.data

import kotlinx.coroutines.flow.Flow

class OfflineMedicationsRepository(private val medicationsDao: MedicationDao) : MedicationsRepository {

    override fun getAllMedicationsStream(): Flow<List<Medication>> = medicationsDao.getMedications()

    override suspend fun insertMedication(medication: Medication) = medicationsDao.insert(medication)

    override suspend fun deleteMedication(medication: Medication) = medicationsDao.delete(medication)

    override suspend fun updateMedication(medication: Medication) = medicationsDao.update(medication)
}