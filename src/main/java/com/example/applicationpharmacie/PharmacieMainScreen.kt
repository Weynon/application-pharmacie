@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.applicationpharmacie

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.applicationpharmacie.pages.AddMedicationScreen
import com.example.applicationpharmacie.pages.HomeScreen
import com.example.applicationpharmacie.pages.MedicationViewModel
import com.example.applicationpharmacie.pages.SummaryScreen
import com.example.applicationpharmacie.pages.UtilisationScreen
import com.example.applicationpharmacie.pages.ViewStockScreen


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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PharmacieApp(
    //viewModel: MedicationViewModel = viewModel(),
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
        // innerPadding -> val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = PharmacieAppScreenName.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ){
            composable(route = PharmacieAppScreenName.Start.name){
                HomeScreen(

                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = PharmacieAppScreenName.Stock.name){
                ViewStockScreen(

                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = PharmacieAppScreenName.NewInfo.name){
                AddMedicationScreen(

                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = PharmacieAppScreenName.NewUtil.name){
                UtilisationScreen(

                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = PharmacieAppScreenName.NewSummary.name){
                SummaryScreen(

                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}