package com.sophiemiller.exercisehelperapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.lifecycleScope
import com.sophiemiller.exercisehelperapp.R
import com.sophiemiller.exercisehelperapp.data.entities.ExerciseSet
import com.sophiemiller.exercisehelperapp.data.entities.SingleExercise
import com.sophiemiller.exercisehelperapp.data.entities.SingleSet
import com.sophiemiller.exercisehelperapp.presentation.viewModel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.content_main)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)



        lifecycleScope.launch(Dispatchers.IO) {
            val exercises = listOf("Plank", "Push-ups", "Pull-ups", "Hand waves", "Downward dog")
            exercises.forEachIndexed { i, exe ->
                viewModel.saveExercise(SingleExercise(id = i, exerciseName = exe))
            }
            viewModel.saveSet(
                ExerciseSet(
                    id = 0,
                    exercisesInTheSet = SingleSet(listOf(1, 2, 5)),
                    defaultSetDuration = 10,
                    defaultSetBreakTime = 10
                )
            )
            viewModel.saveSet(
                ExerciseSet(
                    id = 0,
                    exercisesInTheSet = SingleSet(listOf(1, 3, 4, 5)),
                    defaultSetDuration = 10,
                    defaultSetBreakTime = 10
                )
            )
        }
    }

}