package com.maxim.getdatafromapiandshow.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface Communication {
    fun show(text: String)
    fun observe(owner: LifecycleOwner, observer: Observer<String>)
}