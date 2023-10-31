package com.maxim.getdatafromapiandshow.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.maxim.getdatafromapiandshow.presenatiton.State

interface Communication {
    fun showState(state: State)
    fun observe(owner: LifecycleOwner, observer: Observer<State>)
}