package com.sophiemiller.exercisehelperapp.domain.di

import com.sophiemiller.exercisehelperapp.domain.repository.ExerciseSetsRepository
import com.sophiemiller.exercisehelperapp.domain.repository.ExercisesRepository
import org.koin.dsl.module

val domainModule = module {

    factory { ExercisesRepository(get()) }
    factory { ExerciseSetsRepository(get()) }
}