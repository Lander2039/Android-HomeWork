package com.example.androidhomework.HomeWork1.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidhomework.HomeWork1.data.database.FavoritesEntity
import com.example.androidhomework.HomeWork1.data.database.HomeEntity
import com.example.androidhomework.HomeWork1.data.database.ItemsEntity

@Database(
    entities = [ItemsEntity::class, FavoritesEntity::class, HomeEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ItemsDatabase : RoomDatabase() {

    abstract fun getItemsDAO(): ItemsDAO

    companion object {

        private var DB_INSTANCE: ItemsDatabase? = null

        fun getItemsDatabaseInstance(context: Context): ItemsDatabase {
            return DB_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    ItemsDatabase::class.java,
                    "Items_DB"
                )
                .allowMainThreadQueries()
                .build()
                .also { DB_INSTANCE = it }
        }
    }
}