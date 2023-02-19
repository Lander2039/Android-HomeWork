package com.example.androidhomework.HomeWork1.data.items

import android.util.Log
import com.example.androidhomework.HomeWork1.data.Service.ApiService
import com.example.androidhomework.HomeWork1.data.database.FavoritesEntity
import com.example.androidhomework.HomeWork1.data.database.ItemsEntity
import com.example.androidhomework.HomeWork1.data.database.dao.ItemsDAO
import com.example.androidhomework.HomeWork1.domain.items.ItemsRepository
import com.example.androidhomework.HomeWork1.domain.model.FavoritesModel
import com.example.androidhomework.HomeWork1.domain.model.ItemsArmor
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val itemsDAO: ItemsDAO,
) : ItemsRepository {

    private val compositeDisposable = CompositeDisposable()

    override fun getDate(): Completable {

        return itemsDAO.doesItemsEntityExist()
            .subscribeOn(Schedulers.io())
            .doAfterNext {
                if (!it) {
                    val response = apiService.getData()
                    val getData = response.subscribeOn(Schedulers.io())
                        .doAfterSuccess {
                            it.forEach {
                                val itemsEntity = ItemsEntity(
                                    Random().nextInt(),
                                    it.name,
                                    it.username,
                                    it.email,
                                    it.address.street,
                                    it.address.suite,
                                    it.address.city,
                                    it.address.zipcode,
                                    it.address.geo.lat,
                                    it.address.geo.lng,
                                    it.phone,
                                    it.website,
                                    it.company.name,
                                    it.company.catchPhrase,
                                    it.company.bs,
                                    it.favorite
                                )
                                itemsDAO.insertItemsEntity(itemsEntity)
                            }
                        }
                        .doOnError {
                            Log.w("error", "when making request")
                        }
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
                    compositeDisposable.add(getData)
                }
            }
            .doOnComplete {
                compositeDisposable.dispose()
            }
            .ignoreElements()
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun showData(): io.reactivex.Observable<List<ItemsArmor>> {

        val itemsEntity = itemsDAO.getItemsEntities()
        return itemsEntity.subscribeOn(Schedulers.io())
            .map {
                it.map {
                    ItemsArmor(
                        Random().nextInt(),
                        it.name,
                        it.username,
                        it.email,
                        it.street,
                        it.suite,
                        it.city,
                        it.zipcode,
                        it.lat,
                        it.lng,
                        it.phone,
                        it.website,
                        it.companyName,
                        it.catchPhrase,
                        it.bs,
                        it.favorite
                    )
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
    }

    override suspend fun deleteItemByDescription(name: String) {
        withContext(Dispatchers.IO) {
            itemsDAO.deleteItemEntityByDescription(name)
        }
    }

    override suspend fun findItemByDescription(searchText: String): ItemsArmor {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDAO.findItemEntityByDescription(searchText)
            ItemsArmor(
                Random().nextInt(),
                itemsEntity.name,
                itemsEntity.username,
                itemsEntity.email,
                itemsEntity.street,
                itemsEntity.suite,
                itemsEntity.city,
                itemsEntity.zipcode,
                itemsEntity.lat,
                itemsEntity.lng,
                itemsEntity.phone,
                itemsEntity.website,
                itemsEntity.companyName,
                itemsEntity.catchPhrase,
                itemsEntity.bs,
                itemsEntity.favorite
            )
        }
    }

    override suspend fun favClicked(itemsArmor: ItemsArmor) {
        return withContext(Dispatchers.IO) {
            itemsDAO.insertFavoritesEntity(
                FavoritesEntity(
                    Random().nextInt(),
                    itemsArmor.name,
                    itemsArmor.username,
                    itemsArmor.email,
                    itemsArmor.street,
                    itemsArmor.suite,
                    itemsArmor.city,
                    itemsArmor.zipcode,
                    itemsArmor.lat,
                    itemsArmor.lng,
                    itemsArmor.phone,
                    itemsArmor.website,
                    itemsArmor.companyName,
                    itemsArmor.catchPhrase,
                    itemsArmor.bs,
                    itemsArmor.favorite
                )
            )
        }
    }

    override suspend fun getFavorites(): Flow<List<FavoritesModel>> {
        return withContext(Dispatchers.IO) {
            val favoritesEntity = itemsDAO.getFavoritesEntity()
            favoritesEntity.map { itemsFav ->
                itemsFav.map {
                    FavoritesModel(
                        Random().nextInt(),
                        it.name,
                        it.username,
                        it.email,
                        it.street,
                        it.suite,
                        it.city,
                        it.zipcode,
                        it.lat,
                        it.lng,
                        it.phone,
                        it.website,
                        it.companyName,
                        it.catchPhrase,
                        it.bs,
                        it.favorite
                    )
                }
            }
        }
    }

    override suspend fun deleteFavItemByDescription(name: String) {
        withContext(Dispatchers.IO) {
            itemsDAO.deleteFavItemEntityByDescription(name)
        }
    }

    override suspend fun favoritesDatabaseUpdate(favorite: Boolean, name: String) {
        return withContext(Dispatchers.IO) {
            itemsDAO.favoritesDatabaseUpdate(favorite, name)
        }
    }

//    override suspend fun getHome(homeModel: HomeModel) {
//        withContext(Dispatchers.IO) {
//            itemsDAO.insertHomeEntity(
//                HomeEntity(
//                    homeModel.userName,
//                    homeModel.userPassword
//                )
//            )
//        }
//    }
//
//    override suspend fun getUserHome(): List<HomeModel>{
//        return withContext(Dispatchers.IO) {
//            val homeEntity = itemsDAO.getHomeEntity()
//            homeEntity.map {
//                    HomeModel(
//                        it.userName,
//                        it.userPassword
//                    )
//                }
//            }
//        }
}