package com.kentsanoff.landapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kentsanoff.landapp.navigation.Screen

@Composable
fun StartScreen(navController: NavController) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate(Screen.Form.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Neues Feld anlegen")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate(Screen.Overview.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Felder anzeigen")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate(Screen.Upload.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("SAF Datei hochladen")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate(Screen.Settings.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Einstellungen")
            }
        }
    }
}
