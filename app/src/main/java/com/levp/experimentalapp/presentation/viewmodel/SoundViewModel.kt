package com.levp.experimentalapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SoundViewModel: ViewModel() {

    // Music Button
    val songLoadedState = MutableStateFlow(false)

    fun loadSound() {

        viewModelScope.launch {

            withContext(Dispatchers.Default) {
                // Perform background task  to get the song
                // After the task is completed, call songLoadedSuccessful()
                // Instead of background task, I'm setting 4 seconds delay
                delay(4000)
            }
            loadedSuccessfully()
        }
    }

    private fun loadedSuccessfully() {
        songLoadedState.value = true
    }
}