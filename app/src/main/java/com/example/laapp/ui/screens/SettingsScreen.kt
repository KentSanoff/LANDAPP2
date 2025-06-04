package com.kentsanoff.landapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    val context = LocalContext.current
    var darkTheme by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Einstellungen") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Design")

            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Dunkles Design")
                Switch(
                    checked = darkTheme,
                    onCheckedChange = { darkTheme = it }
                )
            }

            Divider()

            Text("App-Version: 1.0.0")

            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {
                // z.B. Spracheinstellungen öffnen oder zukünftige Aktionen
            }) {
                Text("Sprache ändern")
            }
        }
    }
}
