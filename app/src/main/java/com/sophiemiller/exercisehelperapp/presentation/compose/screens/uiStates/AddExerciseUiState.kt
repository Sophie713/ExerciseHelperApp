package com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates

data class AddExerciseUiState (
    val exerciseName: String? = null,
    val duration: Int? = null,
    val breakTime: Int? = null,
    val showLoading:Boolean = false,
    val showErrorDialog : Boolean = false
)