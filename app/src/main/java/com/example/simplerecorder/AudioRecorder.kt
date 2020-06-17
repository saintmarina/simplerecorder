package com.example.simplerecorder

import android.os.Handler
import android.os.Looper
import android.util.Log

private const val TAG: String = "AudioRecorder"

class AudioRecorder {
    private val handler = Handler(Looper.getMainLooper())
    private var seconds = 0

    private val timer = object : Runnable {
        override fun run() {
            seconds += 1
            Log.i(TAG, "$seconds")
            handler.postDelayed(this, 1000L)
        }

        fun stop() {
            seconds = 0
            handler.removeCallbacksAndMessages(null)
        }
    }

    fun start() {
        timer.run()
    }

    fun stop() {
        timer.stop()
    }
}