package com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates

import com.sophiemiller.exercisehelperapp.data.entities.SingleExercise

data class CreateExerciseSetUIState(
    val setName: String? = null,
    val duration: Int? = null,
    val breakTime: Int? = null,
    val showLoading: Boolean = false,
    val showExercisesDialog: Boolean = false,
    val showErrorDialog: Boolean = false,
    val listExercisesInSet: List<SingleExercise> = listOf(),
    val listAllSavedExercises: List<SingleExercise>? = null,
)