package com.maxim.getdatafromapiandshow.presenatiton

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

sealed class State {

    object Progress : State() {
        override fun show(progressBar: ProgressBar, actionButton: Button) {
            progressBar.visibility = View.VISIBLE
            actionButton.isEnabled = false
        }
    }

    abstract class Info(private val text: String): State() {
        override fun show(progressBar: ProgressBar, actionButton: Button) {
            progressBar.visibility = View.INVISIBLE
            actionButton.isEnabled = true
        }

        override fun show(textView: TextView) {
            textView.text = text
        }
    }

    open class Initial(text: String) : Info(text)
    open class Failed(text: String) : Info(text)


    fun show(progressBar: ProgressBar, actionButton: Button, textView: TextView) {
        show(progressBar, actionButton)
        show(textView)
    }
    open fun show(progressBar: ProgressBar, actionButton: Button) {}
    open fun show(textView: TextView) {}
}