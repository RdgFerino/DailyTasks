package com.example.dailytasks.view

import androidx.lifecycle.ViewModel

data class Task(
    val title: String,
    val description: String,
    val priority: String
)

class TaskViewModel : ViewModel(){
    private val _taskList = mutableListOf<Task>()
    val taskList: List<Task> = _taskList

    fun addTask(task: Task){
        _taskList.add(task)
    }
}