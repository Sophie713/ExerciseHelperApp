package com.sophiemiller.exercisehelperapp.domain.repository

import com.sophiemiller.exercisehelperapp.data.dao.ExerciseDao
import com.sophiemiller.exercisehelperapp.data.entities.SingleExercise

class ExercisesRepository(private val exercisesDao: ExerciseDao) {

    fun saveExercise(newExercise: SingleExercise) {
        exercisesDao.insertExercise(newExercise)
    }
}
