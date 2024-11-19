package com.sophiemiller.exercisehelperapp.presentation.viewModel.events

import com.sophiemiller.exercisehelperapp.data.entities.SingleExercise
import com.sophiemiller.exercisehelperapp.presentation.compose.screens.uiStates.CreateExerciseSetUIState

sealed class CreateExerciseSetVmEvent {
    /**
     * change set's name
     *
     * @property name
     */
    data class OnNameChanged(val name: String) : CreateExerciseSetVmEvent()

    /**
     * change default duration for set's exercise
     *
     * @property defaultDuration
     */
    data class OnDurationChanged(val defaultDuration: String) : CreateExerciseSetVmEvent()

    /**
     * change default break for set's exercise
     *
     * @property defaultBreak
     */
    data class OnBreakChanged(val defaultBreak: String) : CreateExerciseSetVmEvent()


    /**
     * On add exercises  - open dialog with exercises
     *
     * @constructor Create empty On add exercises click
     */
    data object OnAddExercisesClick : CreateExerciseSetVmEvent()

    /**
     * on save set clicked
     */
    data object OnSaveClick : CreateExerciseSetVmEvent()

    /**
     * on user clicking on an exercise in the list to add it to the set //todo xyz show toast
     *
     */
    data class OnAddExercise(val exercise: SingleExercise) : CreateExerciseSetVmEvent()
}