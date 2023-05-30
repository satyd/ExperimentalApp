package com.levp.experimentalapp.presentation.dialog

import android.media.MediaPlayer
import android.util.Log
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.levp.experimentalapp.R
import com.levp.experimentalapp.res.sound.getRandomEnchantSoundId

@Composable
fun EnchantedDialog(onDismiss: () -> Unit) {


    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        title = {
            Text(text = "##<>##")
        },
        text = {
            Text("ℸ ̣ ⍑ᒷ ℸ ̣ ∷⚍ℸ ̣ ⍑ ╎ᓭ リ\uD835\uDE79∴⍑ᒷ∷ᒷ")
        },
        confirmButton = {
            Button(onClick = {
                Log.i("hehe", "on dismiss compose dialog")
                onDismiss()
            }) {
                Text(text = ":?")
            }
        }
    )
}
