package com.example.androidhomework.HomeWork1.di

import android.content.Context
import com.example.androidhomework.HomeWork1.data.database.dao.ItemsDAO
import com.example.androidhomework.HomeWork1.data.database.dao.ItemsDatabase
import dagger.Module
import dagger.Provides

@Module

class DatabaseModule {

    @Provides
    fun provideItemsDao(itemsDatabase: ItemsDatabase): ItemsDAO {
        return itemsDatabase.getItemsDAO()
    }

    @Provides
    fun itemsDatabase(context: Context): ItemsDatabase {
        return ItemsDatabase.getItemsDatabaseInstance(context)
    }
}