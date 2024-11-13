package com.sophiemiller.exercisehelperapp.data.di

import android.content.Context
import androidx.room.Room
import com.sophiemiller.exercisehelperapp.data.EXERCISE_APP_DATABASE
import com.sophiemiller.exercisehelperapp.data.ExerciseDatabase
import com.sophiemiller.exercisehelperapp.data.dao.ExerciseDao
import com.sophiemiller.exercisehelperapp.data.dao.ExerciseSetDao
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.koinApplication
import org.koin.dsl.module

fun provideExercisesDao(database: ExerciseDatabase): ExerciseDao {
    return database.exercisesDao()
}

fun provideExerciseSetsDao(database: ExerciseDatabase): ExerciseSetDao {
    return database.exerciseSetsDao()
}

val databaseModule = module {
    single<ExerciseDatabase> { Room.databaseBuilder(androidApplication(), ExerciseDatabase::class.java, EXERCISE_APP_DATABASE)
        .allowMainThreadQueries()//todo xyz remove later
        .fallbackToDestructiveMigration()
        .build()}
    single<ExerciseDao> {
        val database = get<ExerciseDatabase>()
        database.exercisesDao()
    }
   // single { provideExercisesDao(get()) }
    single<ExerciseSetDao> {
        val database = get<ExerciseDatabase>()
        database.exerciseSetsDao()
    }
}