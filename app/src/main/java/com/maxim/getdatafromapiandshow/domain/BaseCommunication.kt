package com.maxim.getdatafromapiandshow.domain

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.maxim.getdatafromapiandshow.core.Communication

class BaseCommunication: Communication {
    private val liveData = MutableLiveData<String>()

    override fun show(text: String) {
        liveData.value = text
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<String>) {
        liveData.observe(owner, observer)
    }
}