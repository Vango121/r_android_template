package com.example.r_android_template.view.fragments.homeFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.r_android_template.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var _idLiveData: MutableLiveData<Int> = MutableLiveData()
    val idLiveData: LiveData<Int>
        get() = _idLiveData

    init {
        getID()
    }
    @DelicateCoroutinesApi
    fun saveID(id: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            repository.saveId(id)
        }
    }

    @DelicateCoroutinesApi
    fun getID() {
        GlobalScope.launch(Dispatchers.IO) {
            repository.getID().catch { e->
                e.printStackTrace()
            }.collect { _idLiveData.postValue(it) }
        }
    }
}