package com.kentsanoff.landapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kentsanoff.landapp.data.db.LandField
import com.kentsanoff.landapp.data.repository.LandRepository

@Composable
fun DetailScreen(
    fieldId: Int,
    repository: LandRepository,
    onBack: () -> Unit
) {
    var field by remember { mutableStateOf<LandField?>(null) }
    var name by remember { mutableStateOf("") }
    var cropType by remember { mutableStateOf("") }
    var editDate by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        field = repository.getFieldById(fieldId)
        field?.let {
            name = it.name
            cropType = it.cropType
            editDate = it.editDate
            notes = it.notes
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Feld-Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Zurück")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Flächenname") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = cropType,
                onValueChange = { cropType = it },
                label = { Text("Kulturart") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = editDate,
                onValueChange = { editDate = it },
                label = { Text("Bearbeitungsdatum") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = notes,
                onValueChange = { notes = it },
                label = { Text("Notizen") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val updated = field?.copy(
                        name = name,
                        cropType = cropType,
                        editDate = editDate,
                        notes = notes
                    )
                    updated?.let {
                        repository.updateField(it)
                        onBack()
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Speichern")
            }

            /*
            Button(
                onClick = {
                    // repository.exportFieldToPdf(field!!)
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Als PDF exportieren")
            }
            */
        }
    }
}
