package com.maxim.getdatafromapiandshow.presenatiton

abstract class UiItem(private val text: String) {
    fun getText() = text
}

class BaseUiItem(text: String) : UiItem(text)

class FailureUiItem(text: String) : UiItem(text)