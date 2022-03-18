package com.cellodove.retrofit_example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cellodove.retrofit_example.model.ApiRepository
import com.cellodove.retrofit_example.model.ApiResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {
    var apiResponseLiveData = MutableLiveData<ApiResponse>()
    var serverError = MutableLiveData<Exception>()

    fun callApi(pageNumber: String) = GlobalScope.launch {
        try {
            apiResponseLiveData.postValue(ApiRepository.getCartApi().authSignUp(pageNumber))
        }catch (e:Exception){
            serverError.postValue(e)
        }
    }
}