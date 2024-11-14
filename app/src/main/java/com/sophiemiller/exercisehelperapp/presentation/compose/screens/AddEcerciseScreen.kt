package com.sophiemiller.exercisehelperapp.presentation.compose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.sophiemiller.exercisehelperapp.R
import com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates.stateMappers.getBreakText
import com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates.stateMappers.getDurationText
import com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates.stateMappers.getName
import com.sophiemiller.exercisehelperapp.presentation.compose.views.LargeSpacer
import com.sophiemiller.exercisehelperapp.presentation.compose.views.MediumSpacer
import com.sophiemiller.exercisehelperapp.presentation.compose.views.SmallSpacer
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
        LargeSpacer()

        Text(
            text = stringResource(R.string.add_exercise_title),
            style = MaterialTheme.typography.titleLarge
        )
        SmallSpacer()

        Text(
            text = stringResource(R.string.add_exercise_desc),
            style = MaterialTheme.typography.bodyMedium
        )

       MediumSpacer()

        OutlinedTextField(
            value = uiState.value.getName(),
            onValueChange = { value -> viewModel.onEvent(AddExerciseVmEvent.OnNameChanged(value)) },
            label = {Text(stringResource(R.string.add_exercise_exercise_name)) },
            modifier = Modifier.fillMaxWidth()
        )

        SmallSpacer()

        OutlinedTextField(
            value = uiState.value.getDurationText(),
            onValueChange = { value -> viewModel.onEvent(AddExerciseVmEvent.OnDurationChanged(value)) },
            label =  {Text(stringResource(R.string.add_exercise_duration_hint))} ,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        SmallSpacer()

        OutlinedTextField(
            value = uiState.value.getBreakText(),
            onValueChange = { value -> viewModel.onEvent(AddExerciseVmEvent.OnBreakChanged(value))},
            label = {Text(stringResource(R.string.add_exercise_break_hint))},
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        MediumSpacer()

        Button(
            onClick = { viewModel.onEvent(AddExerciseVmEvent.OnSubmit)  },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.add_exercise_save))
        }
    }
}