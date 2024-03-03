package com.example.applicationpharmacie.data

import android.content.Context

interface AppContainer {
    val medicationsRepository: MedicationsRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val medicationsRepository: MedicationsRepository by lazy {
        OfflineMedicationsRepository(PharmacieDatabase.getDatabase(context).medicationDao())
    }
}