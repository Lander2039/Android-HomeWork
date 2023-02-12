package com.example.kotlinlesson.di.component

import com.example.androidhomework.HomeWork1.di.AppModule
import com.example.androidhomework.HomeWork1.di.DataModule
import com.example.androidhomework.HomeWork1.di.DatabaseModule
import com.example.androidhomework.HomeWork1.di.DomainModule
import com.example.androidhomework.HomeWork1.di.component.ScreenScope
import com.example.androidhomework.HomeWork1.presentation.view.auth.HomeFragment
import com.example.androidhomework.HomeWork1.presentation.view.auth.LoginFragment
import com.example.androidhomework.HomeWork1.presentation.view.favorites.FavoritesFragment
import com.example.androidhomework.HomeWork1.presentation.view.home.MainScreenFragment
import com.example.androidhomework.HomeWork1.presentation.view.items.InfoArmorFragment
import com.example.androidhomework.HomeWork1.presentation.view.items.SamuraiArmorFragment
import com.example.androidhomework.HomeWork1.presentation.view.mvp.MainActivity
import com.example.androidhomework.HomeWork1.presentation.view.search.SearchFragment
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        DatabaseModule::class,
        DataModule::class,
        DomainModule::class,
    ]
)

@ScreenScope
interface AppComponent {
    fun inject(fragment: HomeFragment)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: FavoritesFragment)
    fun inject(fragment: MainScreenFragment)
    fun inject(fragment: InfoArmorFragment)
    fun inject(fragment: SamuraiArmorFragment)
    fun inject(activity: MainActivity)
    fun inject(fragment: SearchFragment)
}