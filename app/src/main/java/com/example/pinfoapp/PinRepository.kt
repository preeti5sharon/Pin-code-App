package com.example.pinfoapp

class PinRepository(
    private val pinService: PinService,
) {
    suspend fun getPinDetails(pinCode: String) = pinService.getPinDetails(pinCode)
}
