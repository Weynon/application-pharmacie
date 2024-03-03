package com.example.applicationpharmacie.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onListButtonClicked: () -> Unit,
    onAddButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = { onListButtonClicked() },
            modifier = Modifier,
        ){
            Text("Afficher liste médicaments")
        }
        //Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = { onAddButtonClicked() },
            modifier = Modifier
        ){
            Text("Ajouter médicament")
        }
    }
}