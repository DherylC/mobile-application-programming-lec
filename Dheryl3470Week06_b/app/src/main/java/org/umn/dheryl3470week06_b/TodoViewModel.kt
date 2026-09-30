package org.umn.dheryl3470week06_b

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

class TodoViewModel : ViewModel() {

    private val _todos = MutableStateFlow(listOf<String>())
    val todos: StateFlow<List<String>> = _todos.asStateFlow()

    fun addTodo(task: String) {
        if (task.isBlank()) return
        viewModelScope.launch {
            delay(3000.milliseconds)
            _todos.update { it + task }
        }
    }
}