package com.sophiemiller.exercisehelperapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.sophiemiller.exercisehelperapp.data.TABLE_NAME_EXC_SETS
import com.sophiemiller.exercisehelperapp.data.entities.ExerciseSet

@Dao
interface ExerciseSetDao {
    @Insert(onConflict = REPLACE)
    fun saveExercise(exercise: ExerciseSet)

    @Query("SELECT * FROM $TABLE_NAME_EXC_SETS")
    fun getAllExerciseSets() : List<ExerciseSet>

    @Query("SELECT * FROM $TABLE_NAME_EXC_SETS WHERE id = :id")
    fun getExerciseSetById(id: Int): ExerciseSet?

    @Query("DELETE FROM $TABLE_NAME_EXC_SETS")
    fun deleteAllExerciseSets()

}