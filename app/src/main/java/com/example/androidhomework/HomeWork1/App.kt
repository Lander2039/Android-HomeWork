package com.example.androidhomework.HomeWork1

import android.app.Application
import com.example.androidhomework.HomeWork1.di.AppModule
import com.example.kotlinlesson.di.component.AppComponent
import com.example.kotlinlesson.di.component.DaggerAppComponent


class App : Application() {

    lateinit var appComponent: AppComponent

    fun provideAppComponent(): AppComponent {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        return appComponent
    }
}

//    @Inject
//    lateinit var workerFactory: HiltWorkerFactory
//
//    val applicationScope = CoroutineScope(Dispatchers.Default)
//
//    override fun getWorkManagerConfiguration(): Configuration {
//        return Configuration.Builder()
//            .setWorkerFactory(workerFactory)
//            .setMinimumLoggingLevel(Log.DEBUG)
//            .build()
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        applicationScope.launch {
//            createWorkManager()
//        }
//    }
//
//    private fun createWorkManager() {
//        val repeatingRequest =
//            PeriodicWorkRequestBuilder<PeriodWorker>(15, TimeUnit.MINUTES).setInitialDelay(
//                15,
//                TimeUnit.MINUTES
//            ).build()
//        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
//            PeriodWorker.WORKER_NAME,
//            ExistingPeriodicWorkPolicy.KEEP,
//            repeatingRequest
//        )
//    }
//}