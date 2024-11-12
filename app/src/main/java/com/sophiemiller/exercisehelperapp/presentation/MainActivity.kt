package com.sophiemiller.exercisehelperapp.presentation

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
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
import com.sophiemiller.exercisehelperapp.databinding.ActivityMainBinding
import com.sophiemiller.exercisehelperapp.presentation.viewModel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }


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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}