package com.sophiemiller.exercisehelperapp.presentation.viewModel.events

sealed class AddExerciseVmEvent {
     object OnSubmit : AddExerciseVmEvent()
}