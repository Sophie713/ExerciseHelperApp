package com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates.stateMappers

import androidx.annotation.StringRes
import com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates.AddExerciseUiState

fun AddExerciseUiState.getName(): String {
    this.exerciseName?.let {
        return it
    } ?: run {
        return ""
    }
}

fun AddExerciseUiState.getDurationText(): String {
    this.duration?.let {
        if (it >= 0) {
            return it.toString()
        } else {
            return "0"
        }
    } ?: run {
        return ""
    }
}

fun AddExerciseUiState.getBreakText(): String {
    this.breakTime?.let {
        if (it >= 0) {
            return it.toString()
        } else {
            return "0"
        }
    } ?: run {
        return ""
    }
}