package com.sophiemiller.exercisehelperapp.data.di

import android.content.Context
import androidx.room.Room
import com.sophiemiller.exercisehelperapp.data.EXERCISE_APP_DATABASE
import com.sophiemiller.exercisehelperapp.data.ExerciseDatabase
import com.sophiemiller.exercisehelperapp.data.dao.ExerciseDao
import com.sophiemiller.exercisehelperapp.data.dao.ExerciseSetDao
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun provideExerciseDatabase(context: Context): ExerciseDatabase {
    return Room.databaseBuilder(context, ExerciseDatabase::class.java, EXERCISE_APP_DATABASE)
        .allowMainThreadQueries()//todo xyz remove later
        .fallbackToDestructiveMigration()
       // .addTypeConverter(ExercisesListConverter::class)
        .build()
}
fun provideExercisesDao(database: ExerciseDatabase): ExerciseDao {
    return database.exercisesDao()
}

fun provideExerciseSetsDao(database: ExerciseDatabase): ExerciseSetDao {
    return database.exerciseSetsDao()
}

val databaseModule = module {
    single { provideExerciseDatabase(androidContext()) }
    single { provideExercisesDao(get()) }
    single { provideExerciseSetsDao(get()) }
   // factory { ExercisesRepository(get()) }
   // factory { ExerciseSetsRepository(get()) }
}