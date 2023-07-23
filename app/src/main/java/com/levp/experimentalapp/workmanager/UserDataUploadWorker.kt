package com.levp.experimentalapp.workmanager

import android.content.Context
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.levp.experimentalapp.util.SOUND_TYPE
import com.levp.experimentalapp.util.playSound
import java.util.concurrent.TimeUnit

class UserDataUploadWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        inputData
        uploadUserData()
        return Result.success()
    }

    private fun uploadUserData() {
        //playSound(, SOUND_TYPE.LAN_LIT)
    }
}

fun createWorker(context: Context) {
    val uploadDataConstraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .setRequiresCharging(true)
        .setRequiresBatteryNotLow(true)
        .build()

    val periodicWorkRequest =
        PeriodicWorkRequestBuilder<UserDataUploadWorker>(12, TimeUnit.HOURS).build()


    val userDataJson = "{some data...}"
    val someOtherData = false
    // using workDataOf() method from KTX
    val inputWorkData = workDataOf("user_data" to userDataJson, "other_data" to someOtherData)

    // using Data.Builder
    val inputData = Data.Builder()
        .putString("user_data", userDataJson)
        .putBoolean("other_data", someOtherData)
        .build()

    val oneTimeWorkRequest = OneTimeWorkRequestBuilder<UserDataUploadWorker>()
        .setConstraints(uploadDataConstraints)
        .setInputData(inputData)
        .build()

    WorkManager.getInstance(context).enqueue(oneTimeWorkRequest)
}