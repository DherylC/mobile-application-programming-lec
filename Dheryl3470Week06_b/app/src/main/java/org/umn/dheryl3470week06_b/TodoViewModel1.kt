package org.umn.dheryl3470week06_b

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodoViewModel1 : ViewModel(){
    // the ViewModel creates its own repository
    private val repository = TodoRepository()
    val todos = repository.todos
    fun addTodo(task: String) {
        if (task.isBlank()) return
        viewModelScope.launch {
            repository.addTodo(task)
        }
    }
}