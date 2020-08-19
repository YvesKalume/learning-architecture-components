package com.yveskalumenoble.architecturecomponents.app

import android.app.Application
import com.yveskalumenoble.architecturecomponents.app.di.apiModule
import com.yveskalumenoble.architecturecomponents.app.di.repositoryModule
import com.yveskalumenoble.architecturecomponents.app.di.retrofitModule
import com.yveskalumenoble.architecturecomponents.app.di.viewModelModule
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
            modules(listOf(viewModelModule, repositoryModule, apiModule, retrofitModule))
        }
    }
}