package com.example.androidhomework.HomeWork1.di

import com.example.androidhomework.HomeWork1.domain.ItemsInteractor
import com.example.androidhomework.HomeWork1.domain.ItemsRepository
import com.example.androidhomework.HomeWork1.presentation.view.ItemsPresenter
import com.example.androidhomework.HomeWork1.presentation.view.ItemsView
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

    @Provides
    fun provideItemsPresenter(itemsView: ItemsView, itemsInteractor: ItemsInteractor): ItemsPresenter{
        return ItemsPresenter(itemsView, itemsInteractor)
    }
}