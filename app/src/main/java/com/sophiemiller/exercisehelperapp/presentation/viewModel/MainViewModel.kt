package com.sophiemiller.exercisehelperapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.sophiemiller.exercisehelperapp.data.entities.ExerciseSet
import com.sophiemiller.exercisehelperapp.data.entities.SingleExercise
import com.sophiemiller.exercisehelperapp.domain.repository.ExerciseSetsRepository
import com.sophiemiller.exercisehelperapp.domain.repository.ExercisesRepository

class MainViewModel(
    private val repository: ExercisesRepository,
    private val repository2: ExerciseSetsRepository
) : ViewModel() {

    fun saveExercise(newExercise: SingleExercise) {
        repository.saveExercise(newExercise)
    }

    fun saveSet(newSet: ExerciseSet) {
        repository2.saveExerciseSet(newSet)
    }//todo xyz viewmodel scope not found
}
