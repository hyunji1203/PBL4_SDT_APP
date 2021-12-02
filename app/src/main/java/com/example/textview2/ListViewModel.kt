package com.example.textview2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    private val repo = Repo()
    fun fetchData(): LiveData<MutableList<Data>> {
        val mutableData = MutableLiveData<MutableList<Data>>()
        repo.getData().observeForever{
            mutableData.value = it
        }
        return mutableData
    }
}