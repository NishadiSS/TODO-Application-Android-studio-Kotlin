package com.android.todoapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.android.todoapp.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity is the entry point of the Android application.
 *
 * This class extends [AppCompatActivity] and is annotated with [@AndroidEntryPoint]
 * to indicate that it is a Hilt-enabled Android component.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    /**
     * Called when the activity is starting. This is where most initialization should go:
     * calling [setContentView] to inflate the activity's UI, using [findViewById] to
     * programmatically interact with widgets in the UI, etc.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously
     *     being shut down then this Bundle contains the data it most recently supplied
     *     in [onSaveInstanceState]. Otherwise it is null.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the action bar with the navigation controller
        setupActionBarWithNavController(findNavController(R.id.nav_host_fragment))
    }
    /**
     * This method is called whenever the user chooses to navigate up within your application's
     * activity hierarchy from the action bar.
     *
     * @return `true` if Up navigation completed successfully and this Activity was finished,
     *     `false` otherwise.
     */
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}