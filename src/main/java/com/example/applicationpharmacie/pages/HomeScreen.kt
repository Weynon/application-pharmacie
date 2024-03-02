package com.example.applicationpharmacie.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onListButtonClicked: () -> Unit,
    onAddButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Button(
            onClick = { onListButtonClicked() },
            modifier = Modifier.fillMaxWidth()
        ){
            Text("Afficher liste médicaments")
        }
        // Spacer(modifier = Modifier.height(5.dp))
        Button(
            onClick = { onAddButtonClicked() },
            modifier = Modifier.fillMaxWidth()
        ){
            Text("Ajouter médicament")
        }
    }
}