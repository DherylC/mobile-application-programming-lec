package org.umn.dheryl3470week06_b

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.time.Duration.Companion.milliseconds

class TodoRepository {

    private val _todos = MutableStateFlow(listOf<String>())
    val todos: StateFlow<List<String>> = _todos.asStateFlow()
    suspend fun addTodo(task: String) {
        delay(1000.milliseconds) // pretend: saving to database / API
        _todos.update { it + task }
    }
}