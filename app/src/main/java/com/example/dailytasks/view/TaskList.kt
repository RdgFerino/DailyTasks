package com.example.dailytasks.view



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskList(
    navController: NavController,
    taskViewModel: TaskViewModel
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("My Daily Tasks", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
                ) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("NewTask")
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "icon to save task"
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            if (taskViewModel.taskList.isEmpty()) {
                Text("No tasks yet.", style = MaterialTheme.typography.bodyLarge)
            } else {
                taskViewModel.taskList.forEach { task ->
                    Text(text = "Title: ${task.title}")
                    Text(text = "Description: ${task.description}")
                    Text(text = "Priority: ${task.priority}")
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}