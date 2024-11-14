package com.sophiemiller.exercisehelperapp.presentation.fragments

import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.sophiemiller.exercisehelperapp.presentation.abstractClasses.BaseFragment
import com.sophiemiller.exercisehelperapp.presentation.compose.screens.AddExerciseScreen
import com.sophiemiller.exercisehelperapp.presentation.viewModel.AddExerciseViewModel

class AddExerciseFragment : BaseFragment() {

    private val viewModel: AddExerciseViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                GetScrollableScreen(
                    { AddExerciseScreen(viewModel) }
                )
            }
        }
    }
}