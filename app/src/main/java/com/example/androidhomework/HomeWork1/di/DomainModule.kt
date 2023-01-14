package com.example.androidhomework.HomeWork1.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.androidhomework.HomeWork1.data.sharedPreferences.SharedPreferencesHelper
import com.example.androidhomework.HomeWork1.domain.auth.AuthInteractor
import com.example.androidhomework.HomeWork1.domain.auth.AuthRepository
import com.example.androidhomework.HomeWork1.domain.items.ItemsInteractor
import com.example.androidhomework.HomeWork1.domain.items.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideItemsInteractor(itemsRepository: ItemsRepository): ItemsInteractor {
        return ItemsInteractor(itemsRepository)
    }

    @Provides
    fun provideAuthInteractor(authRepository: AuthRepository): AuthInteractor {
        return AuthInteractor(authRepository)
    }

    companion object {

        private const val SP_KEY = "SP_KEY"

        @Provides
        fun provideSharedPreferences(
            @ApplicationContext context: Context
        ): SharedPreferencesHelper {
            return SharedPreferencesHelper(
                context.getSharedPreferences(SP_KEY, MODE_PRIVATE)
            )
        }
    }
}