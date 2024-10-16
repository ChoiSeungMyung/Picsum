package com.example.picsum.data.remote.service

import com.example.picsum.model.response.PhotoResponse
import retrofit2.http.GET

interface PhotoService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoResponse>
}
