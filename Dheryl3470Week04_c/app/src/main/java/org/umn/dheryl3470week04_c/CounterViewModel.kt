package org.umn.dheryl3470week04_c

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    var count by mutableStateOf( value = 0)
        private set

    fun increment() {
        count++
    }
}