package com.yveskalumenoble.architecturecomponents.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yveskalumenoble.architecturecomponents.data.entity.PictureResponse
import com.yveskalumenoble.architecturecomponents.data.repository.PictureRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureViewModel(private val pictureRepository: PictureRepository) : ViewModel(), Callback<PictureResponse> {
    private val _picturesResponse = MutableLiveData<PictureResponse>()
    val pictures: LiveData<PictureResponse>
        get() = _picturesResponse
    init {
        fetchData()
    }

    private fun fetchData() {
        pictureRepository.getAll().enqueue(this)
    }

    override fun onFailure(call: Call<PictureResponse>, t: Throwable) {
        Log.d("PictureViewModel", "error ${t.message}")
    }

    override fun onResponse(call: Call<PictureResponse>, response: Response<PictureResponse>) {
        if (response.isSuccessful){
            Log.d("PictureViewModel", "success")
            _picturesResponse.value = response.body()
        }
    }
}