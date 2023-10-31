package com.maxim.getdatafromapiandshow.presenatiton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.maxim.getdatafromapiandshow.App
import com.maxim.getdatafromapiandshow.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val actionButton = findViewById<Button>(R.id.actionButton)
        val viewModel = (application as App).viewModel

        actionButton.setOnClickListener {
            viewModel.getItem()
        }

        viewModel.observe(this) { state ->
            if (state is State.Progress) {
                state.show(progressBar, actionButton)
            } else {
                state.show(progressBar, actionButton, textView)
            }
        }
    }
}