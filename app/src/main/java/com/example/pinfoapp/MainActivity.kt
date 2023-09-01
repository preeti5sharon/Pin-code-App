package com.example.pinfoapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.pinfoapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val viewModel: PinViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.button?.setOnClickListener {
            val pinText = binding?.pincodeET?.text.toString()
            binding?.pincode?.text = pinText
            viewModel.getPinDetails(pinText)
        }

        lifecycleScope.launch {
            viewModel.pinDetails.collectLatest {
                binding?.country?.text = it?.country.toString()
                val getPlace = it?.places?.firstOrNull()
                binding?.state?.text = getPlace?.state.toString()
                binding?.place?.text = getPlace?.placeName.toString()
            }
        }
    }
}
