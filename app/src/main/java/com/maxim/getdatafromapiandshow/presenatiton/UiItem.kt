package com.maxim.getdatafromapiandshow.presenatiton

import com.maxim.getdatafromapiandshow.core.Communication

abstract class UiItem(private val text: String) {
    fun getText() = text
    open fun show(communication: Communication) = communication.showState(State.Initial(getText()))
}

class BaseUiItem(text: String) : UiItem(text)

class FailedUiItem(text: String) : UiItem(text) {
    override fun show(communication: Communication) = communication.showState(State.Failed(getText()))
}