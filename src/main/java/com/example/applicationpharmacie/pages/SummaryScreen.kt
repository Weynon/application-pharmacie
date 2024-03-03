package com.example.applicationpharmacie.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.applicationpharmacie.R
import com.example.applicationpharmacie.data.MedicationUiState
import com.example.applicationpharmacie.data.toMedication

@Composable
fun SummaryScreen(
    medicationUiState: MedicationUiState,
    onCancelButtonClicked: () -> Unit,
    onValidateButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    val infos = listOf(
        Pair("Nom du médicament", medicationUiState.medicationDetails.name),
        Pair("Description du médicament", medicationUiState.medicationDetails.description),
        Pair("Type de médicament", medicationUiState.medicationDetails.type),
        Pair("Date de péremption", medicationUiState.medicationDetails.expirationDate)
    )

    val medication = medicationUiState.medicationDetails.toMedication()
    println(medication.toString())

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            infos.forEach{ info ->
                Text(info.first)
                Text(text = info.second, fontWeight = FontWeight.Bold)
                Divider(thickness = 1.dp)
            }
        }
        Row(
            modifier = Modifier
                .padding(15.dp),
            horizontalArrangement = Arrangement.End
        ) {
            OutlinedButton(
                onClick = onCancelButtonClicked,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp)
            ) {
                Text(stringResource(R.string.button_cancel))
            }
            Button(
                onClick = onValidateButtonClicked,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .weight(1f),
            ) {
                Text(stringResource(R.string.button_validate))
            }
        }
    }
}