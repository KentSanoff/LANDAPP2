package com.kentsanoff.landapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.kentsanoff.landapp.ui.screens.FormScreen
import com.kentsanoff.landapp.viewmodel.FormViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Start.route) {

        composable(Screen.Form.route) {
            val formViewModel: FormViewModel = hiltViewModel()
            FormScreen(viewModel = formViewModel, navController = navController)
        }

        // TODO: Weitere Screens wie Start, Overview etc. hier einbauen
    }
}
