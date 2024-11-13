package com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates

data class AddExerciseUiState (
    val exerciseName: String = "",
    val duration: Int = 0,
    val breakTime: Int = 0,
    val showLoading:Boolean = false,
    val showErrorDialog : Boolean = false
)