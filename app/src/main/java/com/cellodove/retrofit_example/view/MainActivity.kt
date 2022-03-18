package com.cellodove.retrofit_example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        binding.numberPicker.minValue = 0
        binding.numberPicker.maxValue = 100

        binding.button.setOnClickListener {
            val number = binding.numberPicker.value.toString()
            binding.showProgress.visibility = View.VISIBLE
            viewModel.callApi(number)
        }
        viewModel()
    }

    private fun viewModel(){
        viewModel.apiResponseLiveData.observe(this) { apiResponse ->
            binding.showProgress.visibility = View.GONE
            binding.apply {
                userId.text = apiResponse.userId.toString()
                id.text = apiResponse.id.toString()
                title.text = apiResponse.title
                body.text = apiResponse.body
            }
        }
        viewModel.serverError.observe(this){ e ->
            binding.showProgress.visibility = View.GONE
            binding.apply {
                userId.text = ""
                id.text = ""
                title.text = ""
                body.text = ""
            }
            Toast.makeText(this,"에러가 발생했습니다.\n${e.message}",Toast.LENGTH_SHORT).show()
        }

    }
}