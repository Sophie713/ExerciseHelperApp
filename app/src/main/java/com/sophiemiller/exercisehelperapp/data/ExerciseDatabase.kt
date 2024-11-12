package com.sophiemiller.exercisehelperapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sophiemiller.exercisehelperapp.data.dao.ExerciseDao
import com.sophiemiller.exercisehelperapp.data.dao.ExerciseSetDao
import com.sophiemiller.exercisehelperapp.data.entities.ExerciseSet
import com.sophiemiller.exercisehelperapp.data.entities.SingleExercise
import com.sophiemiller.exercisehelperapp.data.typeConverters.ConverterSingleSet

@TypeConverters(ConverterSingleSet::class)
@Database(entities = [ExerciseSet::class, SingleExercise::class], version = 1, exportSchema = false)
abstract class ExerciseDatabase : RoomDatabase() {

    abstract fun exercisesDao(): ExerciseDao
    abstract fun exerciseSetsDao(): ExerciseSetDao

}