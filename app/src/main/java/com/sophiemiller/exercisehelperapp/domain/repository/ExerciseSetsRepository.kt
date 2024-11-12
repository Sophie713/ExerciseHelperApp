package com.sophiemiller.exercisehelperapp.domain.repository

import com.sophiemiller.exercisehelperapp.data.dao.ExerciseSetDao
import com.sophiemiller.exercisehelperapp.data.entities.ExerciseSet


class ExerciseSetsRepository(private val exerciseSetsDao: ExerciseSetDao) {

    fun saveSet(newSet : ExerciseSet) {
        exerciseSetsDao.insertExerciseSet(newSet)
    }
}