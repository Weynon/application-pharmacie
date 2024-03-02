package com.example.applicationpharmacie.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.applicationpharmacie.data.MedicationUiState

@Composable
fun SummaryScreen(
    medicationUiState: MedicationUiState,
    onCancelButtonClicked: () -> Unit,
    onValidateButtonClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
){}