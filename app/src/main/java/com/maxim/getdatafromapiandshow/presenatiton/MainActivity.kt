package com.maxim.getdatafromapiandshow.presenatiton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        progressBar.visibility = View.INVISIBLE

        actionButton.setOnClickListener {
            actionButton.isEnabled = false
            progressBar.visibility = View.VISIBLE
            viewModel.getItem()
        }

        viewModel.observe(this) { result ->
            actionButton.isEnabled = true
            progressBar.visibility = View.INVISIBLE
            textView.text = result
        }
    }
}