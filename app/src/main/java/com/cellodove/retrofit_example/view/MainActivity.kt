package com.cellodove.retrofit_example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.get
import androidx.lifecycle.ViewModel
import com.cellodove.retrofit_example.model.ApiRepository
import com.cellodove.retrofit_example.R
import com.cellodove.retrofit_example.databinding.ActivityMainBinding
import com.cellodove.retrofit_example.viewmodel.MainViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel : MainViewModel by viewModels()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val number = binding.numberPicker.value.toString()
            viewModel.callApi(number)
        }
    }
}