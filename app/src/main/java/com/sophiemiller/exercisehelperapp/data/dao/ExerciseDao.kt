package com.sophiemiller.exercisehelperapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.sophiemiller.exercisehelperapp.data.TABLE_NAME_EXERCISES
import com.sophiemiller.exercisehelperapp.data.entities.SingleExercise
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Insert(onConflict = REPLACE)
    fun saveExercise(exercise: SingleExercise)

    @Query("SELECT * FROM $TABLE_NAME_EXERCISES")
    fun getAllExercises(): List<SingleExercise>

    @Query("SELECT * FROM $TABLE_NAME_EXERCISES WHERE id = :id")
    fun getExerciseById(id: Int): SingleExercise?

    @Query("DELETE FROM $TABLE_NAME_EXERCISES")
    fun deleteAllExercises()

}