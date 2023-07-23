package com.levp.experimentalapp

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.levp.experimentalapp.implementation.AnalyticsLoggerImpl
import com.levp.experimentalapp.interfaces.AnalyticsLogger
import com.levp.experimentalapp.presentation.dialog.EnchantedDialog
import com.levp.experimentalapp.presentation.ui.components.Greeting
import com.levp.experimentalapp.presentation.ui.theme.ExperimentalAppTheme
import com.levp.experimentalapp.util.SOUND_TYPE
import com.levp.experimentalapp.util.playSound


class MainActivity : ComponentActivity(), AnalyticsLogger by AnalyticsLoggerImpl() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerLifecycleOwner(this)
        setContent {
            val sContext = LocalContext.current
            val openDialog = remember { mutableStateOf(false) }
            ExperimentalAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(name = "Android", onClick = {
                        playSound(sContext, SOUND_TYPE.LAN_LIT)
                        openDialog.value = true
                    })
                    if (openDialog.value) {
                        EnchantedDialog() {
                            playSound(sContext, SOUND_TYPE.ENCHANT)
                            openDialog.value = false
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExperimentalAppTheme {
        Greeting("Android", {})
    }
}

class JopaService: Service(){
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        val doSomeStuff = {}
    }
}