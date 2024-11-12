package com.sophiemiller.exercisehelperapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sophiemiller.exercisehelperapp.data.TABLE_NAME_EXC_SETS

/**
 * entity for [ExerciseSetsDao]
 *
 * @property id
 * @property exercisesInTheSet
 * @property defaultSetDuration
 * @property defaultSetBreakTime
 * @property overrideExerciseTimeValues
 */
@Entity(tableName = TABLE_NAME_EXC_SETS)
data class ExerciseSet(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val exercisesInTheSet: List<Int>,
    val defaultSetDuration: Int,
    val defaultSetBreakTime: Int,
    val overrideExerciseTimeValues : Boolean = false,
)
