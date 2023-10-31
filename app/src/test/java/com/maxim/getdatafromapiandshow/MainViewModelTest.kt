package com.maxim.getdatafromapiandshow

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.maxim.getdatafromapiandshow.core.Communication
import com.maxim.getdatafromapiandshow.core.Interactor
import com.maxim.getdatafromapiandshow.domain.Item
import com.maxim.getdatafromapiandshow.domain.NoConnectionError
import com.maxim.getdatafromapiandshow.presenatiton.MainViewModel
import kotlinx.coroutines.Dispatchers
import org.junit.*
import org.junit.Assert.assertEquals
import java.lang.IllegalStateException

class MainViewModelTest {
    @Test
    fun test() {
        val interactor = FakeInteractor()
        val communication = FakeCommunication()
        val viewModel = MainViewModel(communication, interactor, Dispatchers.Unconfined)

        interactor.returnSuccess = true
        viewModel.getItem()
        assertEquals("item from server", communication.text)

        interactor.returnSuccess = false
        viewModel.getItem()
        assertEquals("No connection", communication.text)
    }


    private class FakeCommunication() : Communication {
        var text: String = ""
        override fun show(text: String) {
            this.text = text
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<String>) =
            throw IllegalStateException("not used")
    }

    private class FakeInteractor(): Interactor {
        var returnSuccess = true
        override suspend fun getItem(): Item {
            return if(returnSuccess)
                Item.Success("item from server")
            else
                Item.Failed(NoConnectionError())
        }
    }
}