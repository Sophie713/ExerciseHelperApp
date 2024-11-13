package com.sophiemiller.exercisehelperapp.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sophiemiller.exercisehelperapp.domain.repository.ExercisesRepository
import com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates.AddExerciseUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddExerciseViewModel(private val repository: ExercisesRepository) : ViewModel() {

    private val _addExerciseUiState: MutableStateFlow<AddExerciseUiState> =
        MutableStateFlow(AddExerciseUiState())
    val addExerciseUiState: StateFlow<AddExerciseUiState> = _addExerciseUiState

    fun onEvent(event: Any?) {
        //todo xyz
    }
}