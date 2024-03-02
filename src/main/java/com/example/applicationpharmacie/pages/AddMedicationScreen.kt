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
    onValueChange: (Pair<String,String>) -> Unit,
    modifier: Modifier = Modifier
){
    var name by remember { mutableStateOf(TextFieldValue()) }
    var description by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                    onValueChange(Pair("name", name.text))
                },
                label = { Text(stringResource(R.string.textfield_label_name)) },
                placeholder = { Text(stringResource(R.string.textfield_placeholder_name)) }
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
                placeholder = { Text(stringResource(R.string.textfield_placeholder_description)) }
            )
        }
        Row(){
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

fun update(name: TextFieldValue, it: TextFieldValue) {
    println(it)
}

