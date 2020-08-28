package com.yveskalumenoble.architecturecomponents.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yveskalumenoble.architecturecomponents.data.entity.Picture
import com.yveskalumenoble.architecturecomponents.data.repository.PictureRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PictureViewModel(private val pictureRepository: PictureRepository) : ViewModel() {

    val pictures = pictureRepository.data

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                pictureRepository.refreshData()
            }   catch (t: Throwable) {
                Log.d("PictureViewModel","erreur : ${t.message}")
            }
        }
    }
}