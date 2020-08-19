package com.yveskalumenoble.architecturecomponents.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yveskalumenoble.architecturecomponents.data.entity.PictureResponse
import com.yveskalumenoble.architecturecomponents.data.repository.PictureRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureViewModel(private val pictureRepository: PictureRepository) : ViewModel() {
    private val _picturesResponse = MutableLiveData<PictureResponse>()
    val picturesRespone: LiveData<PictureResponse>
        get() = _picturesResponse
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    init {
        fetchData()
    }

    private fun fetchData() {
        coroutineScope.launch {
            try {
                _picturesResponse.value = pictureRepository.getAll().await()
            }   catch (t: Throwable) {
                Log.d("PictureViewModel","erreur : ${t.message}")
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}