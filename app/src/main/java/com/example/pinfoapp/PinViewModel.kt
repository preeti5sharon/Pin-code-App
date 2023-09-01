package com.example.pinfoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PinViewModel @Inject constructor(
    private val repository: PinRepository,
) : ViewModel() {
    private var _pinDetails = MutableStateFlow<PinResponse?>(null)
    val pinDetails = _pinDetails.asStateFlow()

    fun getPinDetails(pinCode: String) = viewModelScope.launch(Dispatchers.IO) {
        _pinDetails.value = repository.getPinDetails(pinCode).body()
    }
}
