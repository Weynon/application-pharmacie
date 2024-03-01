package com.example.applicationpharmacie.pages

import androidx.lifecycle.ViewModel
import com.example.applicationpharmacie.data.MedicationUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MedicationViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MedicationUiState())
    val uiState: StateFlow<MedicationUiState> = _uiState.asStateFlow()

    fun resetOrder() {
        _uiState.value = MedicationUiState()
    }
}