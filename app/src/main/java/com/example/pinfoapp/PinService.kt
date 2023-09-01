package com.example.pinfoapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PinService {
    @GET("/in/{pincode}")
    suspend fun getPinDetails(@Path("pincode") pinCode: String): Response<PinResponse>
}

