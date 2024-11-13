package com.sophiemiller.exercisehelperapp.presentation.abstractClasses

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.verticalScroll
import androidx.fragment.app.Fragment
import com.sophiemiller.exercisehelperapp.presentation.ui.theme.ExerciseAppTheme

abstract class BaseFragment : Fragment() {

    @Composable
    fun GetScrollableScreen(content: @Composable () -> Unit) {
        /**
         * edge to edge padding + scroll
         */
        return ExerciseAppTheme {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding()
                    .verticalScroll(rememberScrollState())

            ) {
                content.invoke()
            }
        }
    }
}