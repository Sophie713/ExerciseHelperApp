package com.sophiemiller.exercisehelperapp.presentation.module

import com.sophiemiller.exercisehelperapp.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { MainViewModel(get(), get()) }

}