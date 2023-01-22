package com.example.androidhomework.HomeWork1.data.Service

import com.example.androidhomework.HomeWork1.data.model.ItemsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    suspend fun getData(): Response<List<ItemsResponse>>
}