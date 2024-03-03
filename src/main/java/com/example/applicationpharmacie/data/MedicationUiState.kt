package com.example.applicationpharmacie.data

import java.time.LocalDate
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MedicationViewModel() : ViewModel() {

    private val _uiState = MutableStateFlow(MedicationUiState())
    val uiState: StateFlow<MedicationUiState> = _uiState.asStateFlow()
    var tempName: String = ""
    var tempDescription: String = ""
    var tempType: String = ""
    var tempExpirationDate: String = ""

    fun setName(name: String){
        this.tempName = name
    }

    fun setDescription(description: String){
        this.tempDescription = description
    }

    fun setType(type: String){
        this.tempType = type
        _uiState.update {
            currentState -> currentState.copy(MedicationDetails(
                id = 0,
                name = this.tempName,
                description = this.tempDescription,
                type = this.tempType,
                expirationDate = this.tempExpirationDate
            ))
        }
    }

    fun setExpirationDate(expirationDate: String){
        this.tempExpirationDate = expirationDate
        //_uiState.update { currentState -> currentState.copy(MedicationDetails(expirationDate=expirationDate)) }
    }

    fun reset() {
        this.tempName = ""
        this.tempDescription = ""
        this.tempType = ""
        this.tempExpirationDate = ""
        _uiState.value = MedicationUiState()
    }

    override fun toString(): String {
        return uiState.value.toString()
    }

    suspend fun saveItem(){
        //medicationsRepository.insertMedication(uiState.value.medicationDetails.toMedication())
    }
}

data class MedicationUiState(
    val medicationDetails: MedicationDetails = MedicationDetails()
)

data class MedicationDetails(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val type: String = "",
    val expirationDate: String = "11-11-2011"
) {
    override fun toString(): String {
        return "MedicationDetails(name='$name', description='$description', type='$type', expirationDate=$expirationDate)"
    }
}

fun MedicationDetails.toMedication(): Medication = Medication(
    id = id,
    name = name,
    description = description,
    type = type,
    expirationDate = expirationDate
)

fun Medication.toMedicationUiState(): MedicationUiState = MedicationUiState(
    medicationDetails = this.toMedicationDetails()
)

fun Medication.toMedicationDetails(): MedicationDetails = MedicationDetails(
    id = id,
    name = name,
    description = description,
    type = type,
    expirationDate = expirationDate
)

