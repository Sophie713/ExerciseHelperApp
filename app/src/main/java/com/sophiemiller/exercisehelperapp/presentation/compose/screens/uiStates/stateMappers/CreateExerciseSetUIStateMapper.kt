package com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates.stateMappers

import com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates.CreateExerciseSetUIState

fun CreateExerciseSetUIState.getDurationText(): String {
    this.duration?.let { return it.toString() } ?: return ""
}

fun CreateExerciseSetUIState.getBreakText(): String {
    this.breakTime?.let { return it.toString() } ?: return ""
}

fun CreateExerciseSetUIState.getName(): String {
    this.setsName?.let { return it } ?: return ""
}