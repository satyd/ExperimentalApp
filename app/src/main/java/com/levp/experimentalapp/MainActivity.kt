package com.levp.experimentalapp

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.os.IBinder
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.tooling.preview.Preview
import com.levp.experimentalapp.broadcast_receivers.AirPlaneModeReceiver
import com.levp.experimentalapp.implementation.AnalyticsLoggerImpl
import com.levp.experimentalapp.interfaces.AnalyticsLogger
import com.levp.experimentalapp.presentation.dialog.EnchantedDialog
import com.levp.experimentalapp.presentation.ui.MainScreen
import com.levp.experimentalapp.presentation.ui.VideoPlayerScreen
import com.levp.experimentalapp.presentation.ui.components.MainButton
import com.levp.experimentalapp.presentation.ui.theme.ExperimentalAppTheme
import com.levp.experimentalapp.util.SOUND_TYPE
import com.levp.experimentalapp.util.playSound


class MainActivity : ComponentActivity(), AnalyticsLogger by AnalyticsLoggerImpl() {

    private val airPlaneModeReceiver = AirPlaneModeReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerLifecycleOwner(this)
        registerReceiver(
            airPlaneModeReceiver,
            IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        )
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.cat_glitch).toString()
        setContent {
            MainScreen(uri = uri)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airPlaneModeReceiver)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExperimentalAppTheme {
        MainButton("Android", {})
    }
}

class JopaService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        val doSomeStuff = {}
    }
}