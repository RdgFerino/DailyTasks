
package com.example.dailytasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dailytasks.ui.theme.DailyTasksTheme
import com.example.dailytasks.view.SaveTask
import com.example.dailytasks.view.TaskList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DailyTasksTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "TaskList"){
                    composable(
                        route = "TaskList"

                    ){
                        TaskList(navController)

                    }

                    composable(
                        route = "SaveTask"
                    ){
                        SaveTask(navController)
                    }
                }

                }
            }
        }
    }

