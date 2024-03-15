package com.example.cse3200_midtermtimerapp.timers

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RightScreenViewModel : ViewModel() {
    private var job: Job? = null
    private var elapsedTime = mutableStateOf(0L)
    private var running = mutableStateOf(false)

    init {
        // Start the coroutine job to update elapsedTime
        job = viewModelScope.launch {
            while (true) {
                if (running.value) {
                    elapsedTime.value++
                }
                delay(1000) // Update every second
            }
        }
    }

    // Method to start the stopwatch
    fun startStopwatch() {
        running.value = true
    }

    // Method to stop the stopwatch
    fun stopStopwatch() {
        running.value = false
    }

    // Method to reset the stopwatch
    fun resetStopwatch() {
        running.value = false
        elapsedTime.value = 0L
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    // Expose elapsedTime as State for observing
    fun getElapsedTime(): State<Long> = elapsedTime

    fun getRunningState(): Any = running
}