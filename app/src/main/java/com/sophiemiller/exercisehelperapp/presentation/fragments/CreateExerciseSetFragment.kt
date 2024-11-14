package com.sophiemiller.exercisehelperapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.sophiemiller.exercisehelperapp.presentation.abstractClasses.BaseFragment
import com.sophiemiller.exercisehelperapp.presentation.compose.screens.CreateExerciseSetScreen

class CreateExerciseSetFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                GetScrollableScreen(
                    { CreateExerciseSetScreen() }
                )
            }
        }
    }
}