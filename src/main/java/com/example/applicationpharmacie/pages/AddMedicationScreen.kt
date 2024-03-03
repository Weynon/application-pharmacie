package com.example.applicationpharmacie.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.applicationpharmacie.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMedicationScreen(
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    onValueChange: (Pair<String,String>) -> Unit,
    modifier: Modifier = Modifier
){
    var name by remember { mutableStateOf(TextFieldValue()) }
    var description by remember { mutableStateOf(TextFieldValue()) }
    var date by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = modifier.padding(top = 120.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row() {
            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                    onValueChange(Pair("name", name.text)) },
                label = { Text(stringResource(R.string.textfield_label_name)) },
                placeholder = { Text(stringResource(R.string.textfield_placeholder_name)) } ,
                keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                )
            )
        }
        Row() {
            OutlinedTextField(
                value = description,
                onValueChange = {
                    description = it
                    onValueChange(Pair("description", description.text))
                },
                label = { Text(stringResource(R.string.textfield_label_description)) },
                placeholder = { Text(stringResource(R.string.textfield_placeholder_description)) },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                )
            )
        }
        Row(){
            OutlinedTextField(
                value = date,
                onValueChange = {
                    date = it
                    onValueChange(Pair("date", date.text))
                },
                label = { Text("Date d'expiration")},
                placeholder = { Text("JJ/MM/AAAA")},
                isError = !isDateWellFormatted(date),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                )
            )
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp, vertical = 15.dp)
        ){
            OutlinedButton(
                onClick = onCancelButtonClicked,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp)
            ) {
                Text(stringResource(R.string.button_cancel))
            }
            Button(
                onClick = onNextButtonClicked,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .weight(1f),
                enabled = isObjectReady(name,description,date)
            ) {
                Text(stringResource(R.string.button_next))
            }
        }
    }
}

private fun isObjectReady(name: TextFieldValue, description: TextFieldValue, date: TextFieldValue): Boolean {
    return name.text != "" && description.text != "" && isDateWellFormatted(date)
}

private fun isDateWellFormatted(date: TextFieldValue): Boolean {
    val pattern = "\\d{2}/\\d{2}/\\d{4}"
    return Regex(pattern).matches(date.text)
}

