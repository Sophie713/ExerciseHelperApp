package com.sophiemiller.exercisehelperapp.domain.repository

import com.sophiemiller.exercisehelperapp.data.dao.ExerciseDao
import com.sophiemiller.exercisehelperapp.data.entities.SingleExercise

class ExercisesRepository(private val exercisesDaoImpl: ExerciseDao) : ExerciseDao {


    override fun saveExercise(exercise: SingleExercise) {
        exercisesDaoImpl.saveExercise(exercise)
    }

    override fun getAllExercises() : List<SingleExercise> {
        return exercisesDaoImpl.getAllExercises()
    }

    override fun getExerciseById(id: Int): SingleExercise? {
        return exercisesDaoImpl.getExerciseById(id)
    }

    override fun deleteAllExercises() {
        return exercisesDaoImpl.deleteAllExercises()
    }
}
