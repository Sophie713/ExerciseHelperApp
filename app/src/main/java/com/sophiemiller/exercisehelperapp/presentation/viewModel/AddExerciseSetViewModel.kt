package com.sophiemiller.exercisehelperapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.sophiemiller.exercisehelperapp.domain.repository.ExerciseSetsRepository
import com.sophiemiller.exercisehelperapp.domain.repository.ExercisesRepository
import com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates.CreateExerciseSetUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddExerciseSetViewModel(private val setsRepository: ExerciseSetsRepository, private val repository: ExercisesRepository) : ViewModel() {
    private val _exerciseSetUIState: MutableStateFlow<CreateExerciseSetUIState> =
        MutableStateFlow(CreateExerciseSetUIState())
    val exerciseSetUIState: StateFlow<CreateExerciseSetUIState> = _exerciseSetUIState

}