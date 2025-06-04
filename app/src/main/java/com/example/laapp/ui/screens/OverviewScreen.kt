package com.kentsanoff.landapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kentsanoff.landapp.data.db.LandField
import com.kentsanoff.landapp.navigation.Screen
import com.kentsanoff.landapp.viewmodel.OverviewViewModel

@Composable
fun OverviewScreen(
    navController: NavController,
    viewModel: OverviewViewModel
) {
    val fields by viewModel.fields.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screen.Form.route)
            }) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {
            items(fields) { field ->
                FieldItem(field = field, onClick = {
                    navController.navigate("${Screen.Detail.route}/${field.id}")
                })
            }
        }
    }
}

@Composable
fun FieldItem(field: LandField, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Name: ${field.name}", style = MaterialTheme.typography.titleMedium)
            Text("Pflanzenart: ${field.cropType}")
            Text("Bearbeitungsdatum: ${field.editDate}")
        }
    }
}
