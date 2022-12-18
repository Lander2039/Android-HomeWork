package com.example.androidhomework.HomeWork1.di

import com.example.androidhomework.HomeWork1.data.ItemsRepositoryImpl
import com.example.androidhomework.HomeWork1.domain.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindItemsRepository(
        itemsRepositoryImpl: ItemsRepositoryImpl
    ): ItemsRepository
}