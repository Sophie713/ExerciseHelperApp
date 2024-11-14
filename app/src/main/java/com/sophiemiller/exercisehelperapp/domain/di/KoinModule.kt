package com.sophiemiller.exercisehelperapp.domain.di

import com.sophiemiller.exercisehelperapp.domain.repository.ExerciseSetsRepository
import com.sophiemiller.exercisehelperapp.domain.repository.ExercisesRepositoryImpl
import org.koin.dsl.module

val domainModule = module {

    factory { ExercisesRepositoryImpl(get()) }
    factory { ExerciseSetsRepository(get()) }
}