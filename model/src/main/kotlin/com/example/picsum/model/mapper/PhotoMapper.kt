package com.example.picsum.model.mapper

import com.example.picsum.model.entity.Photo
import com.example.picsum.model.response.PhotoResponse

fun PhotoResponse.toData(): Photo =
    Photo(
        id = id,
        author = author,
        width = width,
        height = height,
        url = url,
        downloadUrl = downloadUrl,
        checked = false,
    )
