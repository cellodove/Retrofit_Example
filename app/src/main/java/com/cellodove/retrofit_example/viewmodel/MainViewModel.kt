package com.cellodove.retrofit_example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cellodove.retrofit_example.model.ApiRepository
import com.cellodove.retrofit_example.model.ApiResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var apiResponseLiveData = MutableLiveData<ApiResponse>()

    fun callApi(pageNumber: String) = GlobalScope.launch {
        apiResponseLiveData.postValue(ApiRepository.getCartApi().authSignUp(pageNumber))
    }
}