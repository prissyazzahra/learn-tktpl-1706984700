package com.hfad.stopwatch

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast


class StopwatchActivity:Activity() {
    private var seconds = 0
    private var running:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)
        if (savedInstanceState != null)
        {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
        }
        runTimer()
    }

    override fun onBackPressed() {
        val toast = Toast.makeText(applicationContext, "Click EXIT button to close application.", Toast.LENGTH_SHORT)
        toast.show()
    }

    fun onClickStart(v:View) {
        running = true
    }

    fun onClickStop(v:View) {
        running = false
    }

    fun onClickReset(v:View) {
        running = false
        seconds = 0
    }

    fun onClickExit(v:View) {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    private fun runTimer()
    {
        val timeView = findViewById(R.id.time_View) as TextView
        val handler = android.os.Handler()
        handler.post(object:Runnable {
            public override fun run() {
                val hours = (seconds / 3600)
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60
                timeView.text = "$hours:$minutes:$secs"

                if (running) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }
        })
    }
}