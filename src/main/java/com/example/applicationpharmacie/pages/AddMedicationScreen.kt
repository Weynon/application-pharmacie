package com.example.applicationpharmacie.pages

import android.widget.EditText
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.example.applicationpharmacie.R

@Composable
fun AddMedicationScreen(
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier
){
    val name by remember { mutableStateOf(TextFieldValue("")) }
    val description by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ){
            OutlinedTextField(
                value = name,
                onValueChange = onValueChange,
                label = { Text(stringResource(R.string.textfield_label_name))},
                placeholder = { Text(stringResource(R.string.textfield_placeholder_name))}
            )
            OutlinedTextField(
                value = description,
                onValueChange = onValueChange,
                label = { Text(stringResource(R.string.textfield_label_description))},
                placeholder = { Text(stringResource(R.string.textfield_placeholder_description))}
            )
            OutlinedButton(
                onClick = onCancelButtonClicked,
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.button_cancel))
            }
            Button(
                onClick = onNextButtonClicked,
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.button_next))
            }
        }
    }
}