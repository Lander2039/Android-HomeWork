package com.example.androidhomework.HomeWork1.di

import com.example.androidhomework.HomeWork1.domain.auth.AuthInteractor
import com.example.androidhomework.HomeWork1.domain.auth.AuthRepository
import com.example.androidhomework.HomeWork1.domain.items.ItemsInteractor
import com.example.androidhomework.HomeWork1.domain.items.ItemsRepository
import dagger.Module
import dagger.Provides


@Module

class DomainModule {
    @Provides
    fun provideItemsInteractor(itemsRepository: ItemsRepository): ItemsInteractor {
        return ItemsInteractor(itemsRepository)
    }

    @Provides
    fun provideAuthInteractor(authRepository: AuthRepository): AuthInteractor {
        return AuthInteractor(authRepository)
    }


}