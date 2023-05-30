package com.levp.experimentalapp.util

import android.content.Context
import android.media.MediaPlayer
import com.levp.experimentalapp.res.sound.getRandomEnchantSoundId
import com.levp.experimentalapp.res.sound.getRandomLanLitSoundId

enum class SOUND_TYPE {
    ENCHANT, LAN_LIT
}

fun playSound(playerContext: Context, soundType: SOUND_TYPE) {
    val fileId = when (soundType) {
        SOUND_TYPE.ENCHANT -> getRandomEnchantSoundId()
        SOUND_TYPE.LAN_LIT -> getRandomLanLitSoundId()
    }
    val mediaPlayer = MediaPlayer.create(playerContext, fileId)
    mediaPlayer.start()
}