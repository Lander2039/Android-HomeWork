package com.example.androidhomework.HomeWork1.di

import com.example.androidhomework.HomeWork1.domain.ItemsInteractor
import com.example.androidhomework.HomeWork1.domain.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideItemsInteractor(itemsRepository: ItemsRepository): ItemsInteractor {
        return ItemsInteractor(itemsRepository)
    }
}