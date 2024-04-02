package com.example.lookpin.model.mapper

import com.example.lookpin.model.entity.Photo
import com.example.lookpin.model.response.PhotoResponse

fun PhotoResponse.toData(): Photo = Photo(
    id = id,
    author = author,
    width = width,
    height = height,
    url = url,
    downloadUrl = downloadUrl,
    checked = false,
)
