package com.example.applicationpharmacie.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicationDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(medication: Medication)

    @Update
    suspend fun update(medication: Medication)

    @Delete
    suspend fun delete(medication: Medication)

    @Query("SELECT * FROM medicaments ORDER BY name")
    fun getMedications(): Flow<List<Medication>>

    @Query("SELECT * FROM medicaments")
    fun getExpiredMedications(): Flow<Medication>

    @Query("SELECT * FROM medicaments ORDER BY type")
    fun getMedicationsByTypes(): Flow<Medication>
}