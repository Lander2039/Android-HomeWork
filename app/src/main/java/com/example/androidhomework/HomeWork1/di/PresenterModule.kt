package com.example.androidhomework.HomeWork1.di

import com.example.androidhomework.HomeWork1.domain.auth.AuthInteractor
import com.example.androidhomework.HomeWork1.domain.items.ItemsInteractor
import com.example.androidhomework.HomeWork1.presentation.view.auth.HomePresenter
import com.example.androidhomework.HomeWork1.presentation.view.auth.LoginPresenter
import com.example.androidhomework.HomeWork1.presentation.view.favorites.FavoritesPresenter
import com.example.androidhomework.HomeWork1.presentation.view.home.MainScreenPresenter
import com.example.androidhomework.HomeWork1.presentation.view.items.InfoArmorPresenter
import com.example.androidhomework.HomeWork1.presentation.view.items.ItemsPresenter
import com.example.androidhomework.HomeWork1.presentation.view.mvp.MainPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresenterModule {

    @Provides
    fun provideItemsPresenter(itemsInteractor: ItemsInteractor): ItemsPresenter {
        return ItemsPresenter(itemsInteractor)
    }

    @Provides
    fun provideLoginPresenter(authInteractor: AuthInteractor): LoginPresenter {
        return LoginPresenter(authInteractor)
    }

    @Provides
    fun provideInfoArmorPresenter(authInteractor: AuthInteractor): InfoArmorPresenter {
        return InfoArmorPresenter(authInteractor)
    }

    @Provides
    fun provideMainScreenPresenter(): MainScreenPresenter {
        return MainScreenPresenter()
    }

    @Provides
    fun provideMainPresenter(authInteractor: AuthInteractor): MainPresenter {
        return MainPresenter(authInteractor)
    }

    @Provides
    fun provideHomePresenter(authInteractor: AuthInteractor, itemsInteractor: ItemsInteractor): HomePresenter {
        return HomePresenter(authInteractor, itemsInteractor)
    }
    @Provides
    fun provideFavoritesPresenter(itemsInteractor: ItemsInteractor): FavoritesPresenter {
        return FavoritesPresenter(itemsInteractor)
    }
}