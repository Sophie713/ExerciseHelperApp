package com.sophiemiller.exercisehelperapp.presentation.module

import com.sophiemiller.exercisehelperapp.presentation.viewModel.AddExerciseSetViewModel
import com.sophiemiller.exercisehelperapp.presentation.viewModel.AddExerciseViewModel
import com.sophiemiller.exercisehelperapp.presentation.viewModel.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { MainViewModel(get(), get()) }
    viewModel { AddExerciseViewModel(get()) }
    viewModel { AddExerciseSetViewModel(get(), get()) }

}