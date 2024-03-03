@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.applicationpharmacie

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.applicationpharmacie.data.DataSource
import com.example.applicationpharmacie.data.MedicationViewModel
import com.example.applicationpharmacie.pages.AddMedicationScreen
import com.example.applicationpharmacie.pages.HomeScreen
import com.example.applicationpharmacie.pages.SummaryScreen
import com.example.applicationpharmacie.pages.UtilisationScreen
import com.example.applicationpharmacie.pages.ViewStockScreen
import java.time.LocalDate
import java.time.format.DateTimeFormatter


enum class PharmacieAppScreenName(@StringRes val screenName: Int) {
    Start(screenName = R.string.app_homescreen_name),
    Stock(screenName = R.string.app_stock_name),
    NewInfo(screenName = R.string.app_newinfos_name),
    NewUtil(screenName = R.string.app_newutil_name),
    NewSummary(screenName = R.string.app_newsummary_name)
}

@Composable
fun PharmacieAppBar(
    currentScreen: PharmacieAppScreenName,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(title = { Text(stringResource(currentScreen.screenName)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack){
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun PharmacieApp(
    vm: MedicationViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = PharmacieAppScreenName.valueOf(
        backStackEntry?.destination?.route ?: PharmacieAppScreenName.Start.name
    )

    Scaffold(
        topBar = {
            PharmacieAppBar(
                currentScreen = currentScreen,
                canNavigateBack = (navController.previousBackStackEntry != null),
                navigateUp = { navController.navigateUp() }
            )
        }
    ) {
        innerPadding ->
        val uiState by vm.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = PharmacieAppScreenName.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ){
            composable(route = PharmacieAppScreenName.Start.name){
                HomeScreen(
                    onListButtonClicked = {
                        navController.navigate(PharmacieAppScreenName.Stock.name)
                    },
                    onAddButtonClicked = {
                        navController.navigate(PharmacieAppScreenName.NewInfo.name)
                    },
                    modifier = Modifier
                )
            }
            composable(route = PharmacieAppScreenName.Stock.name){
                ViewStockScreen(
                    onReturnButtonClicked = {
                        navController.navigate(PharmacieAppScreenName.Start.name)
                    },
                    medicationList = DataSource.loadMedications(),
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable(route = PharmacieAppScreenName.NewInfo.name){
                AddMedicationScreen(
                    onNextButtonClicked = {
                        navController.navigate(PharmacieAppScreenName.NewUtil.name)
                    },
                    onCancelButtonClicked = {
                        abortNewMedication(vm, navController)
                    },
                    onValueChange = { updateViewModel(vm,it) },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = PharmacieAppScreenName.NewUtil.name){
                val context = LocalContext.current
                UtilisationScreen(
                    onNextButtonClicked = {
                        navController.navigate(PharmacieAppScreenName.NewSummary.name)
                    },
                    onCancelButtonClicked = {
                        abortNewMedication(vm, navController)
                    },
                    onSelectionChanged = { vm.setType(it) },
                    types = DataSource.medicationTypes.map { id -> context.resources.getString(id) },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = PharmacieAppScreenName.NewSummary.name){
                SummaryScreen(
                    medicationUiState = uiState,
                    onCancelButtonClicked = {
                        abortNewMedication(vm, navController)
                    },
                    onValidateButtonClicked = {
                        navController.navigate(PharmacieAppScreenName.Start.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}

fun updateViewModel(vm: MedicationViewModel, value: Pair<String,String>) {
    if (value.first == "name") vm.setName(value.second)
    else if (value.first == "description") vm.setDescription(value.second)
    else vm.setExpirationDate(value.second)
}

fun generateDate(dateAsString: String): LocalDate {
    var date = LocalDate.parse("2011-11-11")
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    if (dateAsString.length == 10) {
        date = LocalDate.parse(dateAsString, formatter)
    }
    return date
}


private fun abortNewMedication(viewModel: MedicationViewModel, navController: NavHostController) {
    viewModel.reset()
    navController.popBackStack(PharmacieAppScreenName.Start.name, inclusive = false)
}
