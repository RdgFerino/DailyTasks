
package com.example.dailytasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dailytasks.ui.theme.DailyTasksTheme
import com.example.dailytasks.view.NewTaskScreen
import com.example.dailytasks.view.SaveTask
import com.example.dailytasks.view.TaskList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DailyTasksTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "TaskList") {
                    composable(
                        route = "TaskList"

                    ) {
                        TaskList(navController)

                    }

                    composable(
                        route = "SaveTask"
                    ) {
                        SaveTask(navController)
                    }

                    composable("new task") {
                        NewTaskScreen(
                            onSaveTask = { navController.popBackStack() }
                        )
                    }

                }
            }
        }
    }
}

