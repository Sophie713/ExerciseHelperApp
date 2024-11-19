package com.sophiemiller.exercisehelperapp.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sophiemiller.exercisehelperapp.data.entities.ExerciseSet
import com.sophiemiller.exercisehelperapp.data.entities.SingleExercise
import com.sophiemiller.exercisehelperapp.domain.repository.ExerciseSetsRepository
import com.sophiemiller.exercisehelperapp.domain.repository.ExercisesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

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
