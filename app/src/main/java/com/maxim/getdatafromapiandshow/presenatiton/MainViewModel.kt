package com.maxim.getdatafromapiandshow.presenatiton

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxim.getdatafromapiandshow.core.Communication
import com.maxim.getdatafromapiandshow.core.Interactor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val communication: Communication,
    private val interactor: Interactor,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
): ViewModel() {
    fun getItem() = viewModelScope.launch(dispatcher) {
        communication.show(interactor.getItem().map().getText())
    }

    fun observe(owner: LifecycleOwner, observer: Observer<String>) {
        communication.observe(owner, observer)
    }
}