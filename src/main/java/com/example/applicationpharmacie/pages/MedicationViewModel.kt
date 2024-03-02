package com.example.applicationpharmacie.pages

import androidx.lifecycle.ViewModel
import com.example.applicationpharmacie.data.MedicationUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Date

class MedicationViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MedicationUiState())
    val uiState: StateFlow<MedicationUiState> = _uiState.asStateFlow()

    fun setName(name: String){
        _uiState.update { currentState -> currentState.copy(name=name) }
    }

    fun setDescription(description: String){
        _uiState.update { currentState -> currentState.copy(description=description) }
    }

    fun setType(type: String){
        _uiState.update { currentState -> currentState.copy(type=type) }
    }

    fun setExpirationDate(expirationDate: Date){
        _uiState.update { currentState -> currentState.copy(expirationDate=expirationDate) }
    }

    fun reset() {
        _uiState.value = MedicationUiState()
    }
}