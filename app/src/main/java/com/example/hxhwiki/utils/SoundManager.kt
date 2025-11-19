package com.example.hxhwiki.utils

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

class SoundManager(private val context: Context) {

    private var mediaPlayer: MediaPlayer? = null

    fun playSound(soundResId: Int) {
        try {
            // Detener sonido anterior si está reproduciéndose
            mediaPlayer?.stop()
            mediaPlayer?.release()

            // Crear nuevo MediaPlayer
            mediaPlayer = MediaPlayer.create(context, soundResId)
            mediaPlayer?.setOnCompletionListener {
                it.release()
                mediaPlayer = null
            }
            mediaPlayer?.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}

@Composable
fun rememberSoundManager(): SoundManager {
    val context = LocalContext.current
    return remember { SoundManager(context) }
}