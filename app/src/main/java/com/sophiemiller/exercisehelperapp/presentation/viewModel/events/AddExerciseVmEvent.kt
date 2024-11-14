package com.sophiemiller.exercisehelperapp.presentation.viewModel.events

sealed class AddExerciseVmEvent {
     data object OnSubmit : AddExerciseVmEvent()
     data class OnNameChanged(val newName: String) : AddExerciseVmEvent()
     data class OnDurationChanged(val newDuration: String) : AddExerciseVmEvent()
     data class OnBreakChanged(val newBreak: String) : AddExerciseVmEvent()
}