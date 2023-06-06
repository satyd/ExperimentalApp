package com.levp.experimentalapp.implementation

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.levp.experimentalapp.interfaces.AnalyticsLogger

class AnalyticsLoggerImpl : AnalyticsLogger, LifecycleEventObserver {
    override fun registerLifecycleOwner(owner: LifecycleOwner) {
        owner.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_RESUME -> Log.i("hehe", "user opened the screen")
            Lifecycle.Event.ON_PAUSE -> Log.i("hehe", "user leaves the screen")
            else -> Unit
        }
    }

}