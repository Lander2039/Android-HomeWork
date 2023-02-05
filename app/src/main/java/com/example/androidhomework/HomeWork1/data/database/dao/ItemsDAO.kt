package com.example.androidhomework.HomeWork1.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidhomework.HomeWork1.data.database.FavoritesEntity
import com.example.androidhomework.HomeWork1.data.database.HomeEntity
import com.example.androidhomework.HomeWork1.data.database.ItemsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemsDAO {

    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("SELECT * From ItemsEntity ")
    fun getItemsEntities(): Flow<List<ItemsEntity>>

    @Query("SELECT (SELECT COUNT(*) FROM ItemsEntity) != 0")
    fun doesItemsEntityExist(): Boolean

    @Query("DELETE FROM ItemsEntity WHERE name =:name")
    fun deleteItemEntityByDescription(name: String)

    @Query("SELECT * FROM ItemsEntity WHERE name = :searchText")
    fun findItemEntityByDescription(searchText: String): ItemsEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE) // игнорирование если они одинаковы
    fun insertFavoritesEntity(favoritesEntity: FavoritesEntity)

    @Query("SELECT * FROM FavoritesEntity")
    fun getFavoritesEntity(): Flow<List<FavoritesEntity>>

    @Query("DELETE FROM FavoritesEntity WHERE name =:name")
    fun deleteFavItemEntityByDescription(name: String)

    @Insert
    fun insertHomeEntity(homeEntity: HomeEntity)

    @Query("SELECT * FROM HomeEntity")
    fun getHomeEntity(): List<HomeEntity>


}