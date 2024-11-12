package com.sophiemiller.exercisehelperapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sophiemiller.exercisehelperapp.data.TABLE_NAME_EXERCISES

/**
 * entity for [ExercisesDao]
 * table to save your sets so that you can reuse them
 *
 * @property id - not nullable - id is used in the list of sets
 * @property exerciseName - not nullable - name of the exercise
 * @property duration - default duration of the exercise
 * @property breakTime - default break time after the exercise
 */
@Entity(tableName = TABLE_NAME_EXERCISES)
data class SingleExercise(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val exerciseName: String,
    val duration: Int? = null,
    val breakTime: Int? = null,
)
