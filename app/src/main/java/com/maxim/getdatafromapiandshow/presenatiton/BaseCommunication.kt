package com.maxim.getdatafromapiandshow.presenatiton

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.maxim.getdatafromapiandshow.presenatiton.State
import com.maxim.getdatafromapiandshow.core.Communication

class BaseCommunication: Communication {
    private val liveData = MutableLiveData<State>()

    override fun showState(state: State) {
        liveData.value = state
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<State>) {
        liveData.observe(owner, observer)
    }
}