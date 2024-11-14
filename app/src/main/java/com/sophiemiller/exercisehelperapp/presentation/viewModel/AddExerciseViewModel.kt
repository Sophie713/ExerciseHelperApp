package com.sophiemiller.exercisehelperapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.sophiemiller.exercisehelperapp.data.entities.SingleExercise
import com.sophiemiller.exercisehelperapp.domain.repository.ExercisesRepository
import com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates.AddExerciseUiState
import com.sophiemiller.exercisehelperapp.presentation.viewModel.events.AddExerciseVmEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddExerciseViewModel(private val repository: ExercisesRepository) : ViewModel() {

    private val _addExerciseUiState: MutableStateFlow<AddExerciseUiState> =
        MutableStateFlow(AddExerciseUiState())
    val addExerciseUiState: StateFlow<AddExerciseUiState> = _addExerciseUiState

    fun onEvent(event: AddExerciseVmEvent) {
        when (event) {
            is AddExerciseVmEvent.OnNameChanged -> {
                _addExerciseUiState.value = addExerciseUiState.value.copy(
                    exerciseName = event.newName
                )
            }

            is AddExerciseVmEvent.OnBreakChanged -> {
                event.newBreak.toIntOrNull()?.let {
                    _addExerciseUiState.value = addExerciseUiState.value.copy(
                        breakTime = it
                    )
                }
            }

            is AddExerciseVmEvent.OnDurationChanged -> {
                event.newDuration.toIntOrNull()?.let {
                    _addExerciseUiState.value = addExerciseUiState.value.copy(
                        duration = it
                    )
                }
            }

            AddExerciseVmEvent.OnSubmit -> {//todo xyz viewmodel scope
                addExerciseUiState.value.exerciseName?.let {
                    repository.saveExercise(
                        SingleExercise(
                            exerciseName = it,
                            duration = addExerciseUiState.value.duration,
                            breakTime = addExerciseUiState.value.breakTime
                        )
                    )
                }
            }
        }
    }
}