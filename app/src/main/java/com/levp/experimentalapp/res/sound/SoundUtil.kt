package com.levp.experimentalapp.res.sound

import com.levp.experimentalapp.res.sound.enums.EnchantSounds
import com.levp.experimentalapp.res.sound.enums.LanLitSounds

inline fun <reified T : Enum<T>> randomSound(): T {
    return enumValues<T>().toList().shuffled().first()
}

fun getRandomEnchantSoundId(): Int {
    return randomSound<EnchantSounds>().rawFileId
}

fun getRandomLanLitSoundId(): Int {
    return randomSound<LanLitSounds>().rawFileId
}