package com.example.simplerecorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG: String = "MainActivity"

class MainActivity : AppCompatActivity() {
    private var state: State = State.IDLE
    private lateinit var recorder: AudioRecorder

    enum class State {
        IDLE,
        RECORDING
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recorder = AudioRecorder()

        btnStart.setOnClickListener {
            toggleStartStop()
            setUI()
        }

    }

    private fun toggleStartStop() {
        when (state) {
            State.IDLE -> start()
            State.RECORDING -> stop()
        }
    }

    private fun setUI() {
        btnStart.apply {
            text = when (state) {
                State.IDLE -> "START"
                State.RECORDING -> "STOP"
            }
        }

    }

    private fun start() {
        Log.i(TAG, "start")
        state = State.RECORDING
        recorder.start()
    }

    private fun stop() {
        Log.i(TAG, "stop")
        state = State.IDLE
        recorder.stop()
    }
}
