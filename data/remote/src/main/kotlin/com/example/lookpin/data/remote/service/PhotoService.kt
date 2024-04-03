package com.example.lookpin.data.remote.service

import com.example.lookpin.model.response.PhotoResponse
import retrofit2.http.GET

interface PhotoService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoResponse>
}
