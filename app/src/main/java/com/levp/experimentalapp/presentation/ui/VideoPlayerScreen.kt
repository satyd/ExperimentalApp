package com.levp.experimentalapp.presentation.ui

import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@Composable
@SuppressWarnings("FunctionName")
fun VideoPlayerScreen(
    videoUri: String,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    var playWhenReady by remember { mutableStateOf(true) }
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(videoUri))
            repeatMode = ExoPlayer.REPEAT_MODE_OFF
            this.playWhenReady = playWhenReady
            prepare()
            play()
        }
    }
    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        modifier = Modifier.wrapContentSize(),
        title = {},
        text = {
            DisposableEffect(
                AndroidView(
                    modifier = Modifier.wrapContentSize(),
                    factory = {
                        PlayerView(context).apply {
                            player = exoPlayer
                            useController = true
                            FrameLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT
                            )
                        }
                    }
                )
            ) {
                onDispose {
                    exoPlayer.release()
                }
            }
        },
        confirmButton = {}
    )
}

suspend fun callSelf(){
    delay(100)
    return callSelf()
}