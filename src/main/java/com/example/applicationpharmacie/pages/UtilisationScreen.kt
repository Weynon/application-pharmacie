package com.example.applicationpharmacie.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.applicationpharmacie.R

@Composable
fun UtilisationScreen(
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    onSelectionChanged: (String) -> Unit,
    types: List<String>,
    modifier: Modifier = Modifier
){
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column(){
            types.forEach{ type ->
                Row(
                    modifier = Modifier.selectable(
                        selected = selectedValue == type,
                        onClick = {
                            selectedValue = type
                            onSelectionChanged(type)
                        }
                    ).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    RadioButton(
                        selected = selectedValue == type,
                        onClick = {
                            selectedValue = type
                            onSelectionChanged(type)
                        }
                    )
                    Text(type)
                }
            }
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
                enabled = isTypeSelected(selectedValue)
            ) {
                Text(stringResource(R.string.button_next))
            }
        }
    }
}

private fun isTypeSelected(selectedValue: String): Boolean {
    return selectedValue != ""
}
