package com.levp.experimentalapp.interfaces

import androidx.lifecycle.LifecycleOwner

interface AnalyticsLogger {
    fun registerLifecycleOwner(owner: LifecycleOwner)
}