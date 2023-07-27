package com.levp.experimentalapp.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.levp.experimentalapp.presentation.dialog.EnchantedDialog
import com.levp.experimentalapp.presentation.ui.components.MainButton
import com.levp.experimentalapp.presentation.ui.theme.ExperimentalAppTheme
import com.levp.experimentalapp.util.SOUND_TYPE
import com.levp.experimentalapp.util.playSound
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@Composable
fun MainScreen(uri: String) {
    val sContext = LocalContext.current
    val openDialog = remember { mutableStateOf(false) }
    val openVideo = remember { mutableStateOf(false) }
    ExperimentalAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                MainButton(name = "Android", onClick = {
                    playSound(sContext, SOUND_TYPE.LAN_LIT)
                    openDialog.value = true
                })
                MainButton(name = "Get CAtNR", onClick = {
                    openVideo.value = true
                })
            }
            if (openDialog.value) {
                EnchantedDialog() {
                    playSound(sContext, SOUND_TYPE.ENCHANT)
                    openDialog.value = false
                }
            }
            if (openVideo.value) {
                VideoPlayerScreen(videoUri = uri) {
                    openVideo.value = false
                }
            }
        }
    }
}