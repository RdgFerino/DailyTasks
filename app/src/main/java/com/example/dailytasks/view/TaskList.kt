package com.example.dailytasks.view




import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material.icons.filled.LowPriority
import androidx.compose.ui.Alignment
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
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .combinedClickable(
                                onClick = {},
                                onLongClick = {
                                    taskViewModel.removeTask(task)
                                }
                            ),
                        elevation = CardDefaults.cardElevation(4.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                           Icon(
                               imageVector = getPriorityIcon(task.priority),
                               contentDescription = "Priority Icon",
                               tint = getPriorityColor(task.priority),
                               modifier = Modifier.padding(end = 12.dp)
                           )
                        }
                        Column {
                            Text(
                                text = task.title,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = task.description,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Priority: ${task.priority}",
                                style = MaterialTheme.typography.labelMedium,
                                color =getPriorityColor(task.priority)
                            )
                        }

                    }

                }
            }
        }
    }
}

fun getPriorityColor(priority: String): Color {
    return when (priority) {
        "High" -> Color.Red
        "Medium" -> Color(0xFFFFA500)
        "Low" -> Color(0xFF4CAF50)
        else -> Color.Gray
    }
}

fun getPriorityIcon(priority: String): ImageVector {
    return when (priority) {
        "High" -> Icons.Default.Warning
        "Medium" -> Icons.Default.PriorityHigh
        "Low" -> Icons.Default.LowPriority
        else -> Icons.Default.PriorityHigh

    }
}