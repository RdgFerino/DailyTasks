package com.example.dailytasks.view

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class Task(
    val title: String,
    val description: String,
    val priority: String
)

class TaskViewModel : ViewModel() {
    var taskList = mutableStateListOf<Task>()
        private set

    fun addTask(task: Task) {
        taskList.add(task)
    }

    fun removeTask(task: Task) {
        taskList.remove(task)
    }
}