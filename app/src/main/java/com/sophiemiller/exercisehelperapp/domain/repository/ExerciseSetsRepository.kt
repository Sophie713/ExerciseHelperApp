package com.sophiemiller.exercisehelperapp.domain.repository

import com.sophiemiller.exercisehelperapp.data.dao.ExerciseSetDao
import com.sophiemiller.exercisehelperapp.data.entities.ExerciseSet


class ExerciseSetsRepository(private val exerciseSetsDaoImpl: ExerciseSetDao) : ExerciseSetDao {
    override fun saveExerciseSet(exercise: ExerciseSet) {
        exerciseSetsDaoImpl.saveExerciseSet(exercise)
    }

    override fun getAllExerciseSets(): List<ExerciseSet> {
        return exerciseSetsDaoImpl.getAllExerciseSets()
    }

    override fun getExerciseSetById(id: Int): ExerciseSet? {
        return exerciseSetsDaoImpl.getExerciseSetById(id)
    }

    override fun deleteAllExerciseSets() {
        exerciseSetsDaoImpl.deleteAllExerciseSets()
    }

}