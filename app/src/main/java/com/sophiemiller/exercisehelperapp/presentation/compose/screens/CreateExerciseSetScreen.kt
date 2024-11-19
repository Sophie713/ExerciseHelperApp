package com.sophiemiller.exercisehelperapp.presentation.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.sophiemiller.exercisehelperapp.R
import com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates.stateMappers.getBreakText
import com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates.stateMappers.getDurationText
import com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates.stateMappers.getName
import com.sophiemiller.exercisehelperapp.presentation.compose.views.LargeSpacer
import com.sophiemiller.exercisehelperapp.presentation.compose.views.MediumSpacer
import com.sophiemiller.exercisehelperapp.presentation.compose.views.SmallSpacer
import com.sophiemiller.exercisehelperapp.presentation.viewModel.AddExerciseSetViewModel
import com.sophiemiller.exercisehelperapp.presentation.viewModel.events.AddExerciseVmEvent
import com.sophiemiller.exercisehelperapp.presentation.viewModel.events.CreateExerciseSetVmEvent

@Composable
fun CreateExerciseSetScreen(viewModel: AddExerciseSetViewModel) {

    val uiState = viewModel.exerciseSetUIState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Title
        LargeSpacer()
        Text(
            text = stringResource(R.string.create_set_title),
            fontSize = 24.sp,
            style = MaterialTheme.typography.titleLarge
        )

        // Description
        SmallSpacer()
        Text(
            text = stringResource(R.string.create_set_desc),
            style = MaterialTheme.typography.bodyMedium
        )

        MediumSpacer()
        OutlinedTextField(
            value = uiState.value.getName(),
            onValueChange = { value ->
                viewModel.onEvent(
                    CreateExerciseSetVmEvent.OnNameChanged(
                        value
                    )
                )
            },
            label = { Text(stringResource(R.string.create_set_name_hint)) },
            modifier = Modifier.fillMaxWidth()
        )

        // List of items with plus icon
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stringResource(R.string.create_set_list_title))
            IconButton(onClick = { viewModel.onEvent(CreateExerciseSetVmEvent.OnAddExercisesClick) }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.create_set_add)
                )
            }
        }

        // Display the list of selected exercises
        LazyColumn(modifier = Modifier.height(150.dp)) {
            items(uiState.value.listExercisesInSet) { item ->
                Text(text = item.exerciseName, modifier = Modifier.padding(4.dp))
            }
        }

        // Default exercise time
        OutlinedTextField(
            value = uiState.value.getDurationText(),
            onValueChange = { value ->
                viewModel.onEvent(
                    CreateExerciseSetVmEvent.OnDurationChanged(
                        value
                    )
                )
            },
            label = { Text(stringResource(R.string.create_set_def_time_hint)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Default break time
        OutlinedTextField(
            value = uiState.value.getBreakText(),
            onValueChange = { value ->
                viewModel.onEvent(
                    CreateExerciseSetVmEvent.OnBreakChanged(
                        value
                    )
                ) },
            label = { Text(stringResource(R.string.create_set_break_time_hint)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Button to open the dialog
        Button(
            onClick = { viewModel.onEvent(CreateExerciseSetVmEvent.OnSaveClick)},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.create_set_save_btn_txt))
        }

        // Overlay scrollable dialog
        if (uiState.value.showExercisesDialog) {
            Dialog(
                onDismissRequest = { /** todo xyz hide dialog */ }
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(R.string.create_set_dialog_title),
                            fontSize = 20.sp,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        LazyColumn(modifier = Modifier.height(200.dp)) {
                            uiState.value.listAllSavedExercises?.let { allExercises ->
                                items(allExercises) { item ->
                                    Text(
                                        text = item.exerciseName, //todo xyz build whole text via mapper
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable { /* todo xyz add to list of selected exercises */ }
                                            .padding(8.dp)
                                    )
                                }
                            } ?: run {
                                //todo xyz show loading
                            }
                        }

                        LargeSpacer()

                        Button(
                            onClick = { /** close dialog + update list now ??*/ },
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text("Close")
                        }
                    }
                }
            }
        }
    }
}