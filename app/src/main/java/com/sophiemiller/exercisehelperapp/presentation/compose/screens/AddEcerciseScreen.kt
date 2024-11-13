package com.sophiemiller.exercisehelperapp.presentation.compose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.sophiemiller.exercisehelperapp.presentation.viewModel.AddExerciseViewModel
import com.sophiemiller.exercisehelperapp.presentation.viewModel.events.AddExerciseVmEvent

@Composable
fun AddExerciseScreen(viewModel: AddExerciseViewModel) {

    val uiState = viewModel.addExerciseUiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Title",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "This is a description for the screen.",
            style = MaterialTheme.typography.bodyMedium
        )

        OutlinedTextField(
            value = "Add new exercise",
            onValueChange = { viewModel.onEvent(this) },
            label = {Text("Title Input") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = uiState.value.duration.toString(),
            onValueChange = { viewModel.onEvent(this) },
            label =  {Text("Optional: exercise duration")} ,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = uiState.value.breakTime.toString(),
            onValueChange = { viewModel.onEvent(this) },
            label = {Text("Optional: timeout after exercise")},
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { viewModel.onEvent(AddExerciseVmEvent.OnSubmit)  },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}