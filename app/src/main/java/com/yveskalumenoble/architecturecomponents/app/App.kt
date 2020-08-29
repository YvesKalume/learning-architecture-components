package com.yveskalumenoble.architecturecomponents.app

import android.app.Application
import com.yveskalumenoble.architecturecomponents.app.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(viewModelModule, repositoryModule, apiModule, retrofitModule, databaseModule))
        }
    }
}