package com.cellodove.retrofit_example.viewmodel

import androidx.lifecycle.ViewModel
import com.cellodove.retrofit_example.model.ApiRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {



    fun callApi(pageNumber: String) = GlobalScope.launch {
        ApiRepository.getCartApi().authSignUp(pageNumber)
    }
}