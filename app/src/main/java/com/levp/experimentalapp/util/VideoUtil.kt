package com.levp.experimentalapp.util


import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import com.levp.experimentalapp.res.sound.getRandomEnchantSoundId
import com.levp.experimentalapp.res.sound.getRandomLanLitSoundId


sealed class VideoType(val localUri: String = "") {
    data class CatVid(val catVidUri: String) : VideoType(catVidUri) {

    }
}

fun playVideo(playerContext: Context, soundType: SOUND_TYPE) {
    val fileId = when (soundType) {
        SOUND_TYPE.ENCHANT -> getRandomEnchantSoundId()
        SOUND_TYPE.LAN_LIT -> getRandomLanLitSoundId()
    }
    val mediaPlayer = MediaPlayer.create(playerContext, fileId)
    mediaPlayer.start()
}