package com.sophiemiller.exercisehelperapp.domain.repository

import com.sophiemiller.exercisehelperapp.data.dao.ExerciseDao
import com.sophiemiller.exercisehelperapp.data.entities.SingleExercise
import com.sophiemiller.exercisehelperapp.domain.repository.interfaces.ExercisesRepository
import kotlinx.coroutines.flow.Flow

class ExercisesRepositoryImpl(private val exercisesDaoImpl: ExerciseDao) : ExerciseDao {


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
