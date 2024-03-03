package com.example.applicationpharmacie.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Medication::class], version = 1, exportSchema = false)
abstract class PharmacieDatabase : RoomDatabase() {

    abstract fun medicationDao(): MedicationDao

    companion object {

        @Volatile
        private var Instance: PharmacieDatabase? = null

        fun getDatabase(context: Context): PharmacieDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, PharmacieDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}