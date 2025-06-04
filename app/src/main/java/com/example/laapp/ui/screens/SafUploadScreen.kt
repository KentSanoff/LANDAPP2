package com.kentsanoff.landapp.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.io.InputStream

@Composable
fun SafUploadScreen() {
    val context = LocalContext.current
    var selectedFileUri by remember { mutableStateOf<Uri?>(null) }
    var message by remember { mutableStateOf("") }

    val filePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument(),
        onResult = { uri ->
            selectedFileUri = uri
            message = if (uri != null) "Datei ausgewählt: $uri" else "Keine Datei ausgewählt"
        }
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("SAF-Datei hochladen") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = {
                filePicker.launch(arrayOf("*/*"))
            }) {
                Text("Datei auswählen")
            }

            Text(text = message)

            selectedFileUri?.let { uri ->
                Button(onClick = {
                    try {
                        val inputStream: InputStream? =
                            context.contentResolver.openInputStream(uri)
                        // Hier: XML oder CSV lesen + analysieren
                        inputStream?.close()
                        message = "Datei erfolgreich verarbeitet"
                    } catch (e: Exception) {
                        message = "Fehler beim Lesen der Datei: ${e.message}"
                    }
                }) {
                    Text("Hochladen")
                }
            }
        }
    }
}
