package com.example.applicationpharmacie.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.applicationpharmacie.data.Medication

@Composable
fun ViewStockScreen(
    medicationList: List<Medication>,
    onReturnButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    val medication = medicationList[0]
    Column(modifier = modifier){
        MedicationList(medicationList = medicationList)
    }
}
@Composable
fun MedicationList(medicationList: List<Medication>, modifier: Modifier = Modifier){
    LazyColumn (modifier = Modifier) {
        items(medicationList){medication ->
            MedicationComposable(medication = medication)
        }
    }
}

@Composable
fun MedicationComposable(medication: Medication) {
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .background(Color.Red)) {
        Column (modifier = Modifier.padding(8.dp)){
            Row(modifier = Modifier){
                Text(medication.name, fontWeight = FontWeight.Bold)
            }
            Row (){
                Text(medication.description)
            }
            Row (Modifier.fillMaxWidth()){
                Text(medication.type, modifier = Modifier)
            }
            Row (Modifier.fillMaxWidth()) {
                Text(medication.expirationDate)
            }
        }
    }
}

