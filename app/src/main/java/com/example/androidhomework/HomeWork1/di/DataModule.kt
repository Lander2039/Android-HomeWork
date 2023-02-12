package com.example.androidhomework.HomeWork1.di

import android.content.Context
import com.example.androidhomework.HomeWork1.data.Service.ApiService
import com.example.androidhomework.HomeWork1.data.auth.AuthRepositiryImpl
import com.example.androidhomework.HomeWork1.data.items.ItemsRepositoryImpl
import com.example.androidhomework.HomeWork1.data.sharedPreferences.SharedPreferencesHelper
import com.example.androidhomework.HomeWork1.domain.auth.AuthRepository
import com.example.androidhomework.HomeWork1.domain.items.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module


abstract class DataModule {

    @Binds
    abstract fun bindItemsRepository(
        itemsRepositoryImpl: ItemsRepositoryImpl
    ): ItemsRepository

    @Binds
    abstract fun bindLoginRepository(
        authRepositiryImpl: AuthRepositiryImpl
    ): AuthRepository

    companion object {

        private const val SP_KEY = "SP_KEY"
        val BASE_URL = "https://jsonplaceholder.typicode.com"

        @Provides
        fun provideSharedPreferences(
            context: Context
        ): SharedPreferencesHelper {
            return SharedPreferencesHelper(
                context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE)
            )
        }

        @Provides
        fun provideRetrofitIml(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }

        @Provides
        fun provideRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}