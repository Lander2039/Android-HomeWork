package com.example.androidhomework.HomeWork1.data.Service

import com.example.androidhomework.HomeWork1.data.model.ItemsResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    fun getData(): Single<List<ItemsResponse>>
}