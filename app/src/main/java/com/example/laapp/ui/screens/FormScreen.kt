package com.kentsanoff.landapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kentsanoff.landapp.viewmodel.FormViewModel

@Composable
fun FormScreen(
    viewModel: FormViewModel,
    navController: NavController
) {
    val name by viewModel.name.collectAsState()
    val cropType by viewModel.cropType.collectAsState()
    val editDate by viewModel.editDate.collectAsState()
    val notes by viewModel.notes.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = viewModel::updateName,
            label = { Text("Feldname") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = cropType,
            onValueChange = viewModel::updateCropType,
            label = { Text("Pflanzenart") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = editDate,
            onValueChange = viewModel::updateEditDate,
            label = { Text("Bearbeitungsdatum") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = notes,
            onValueChange = viewModel::updateNotes,
            label = { Text("Notizen") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                viewModel.saveField {
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Speichern")
        }
    }
}
