package com.yveskalumenoble.architecturecomponents.app.di

import android.app.Application
import androidx.room.Room
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.yveskalumenoble.architecturecomponents.data.api.PictureApi
import com.yveskalumenoble.architecturecomponents.data.repository.PictureRepository
import com.yveskalumenoble.architecturecomponents.data.room.AppDatabase
import com.yveskalumenoble.architecturecomponents.data.room.dao.PictureDao
import com.yveskalumenoble.architecturecomponents.ui.viewmodel.PictureViewModel
import com.yveskalumenoble.architecturecomponents.util.CONSTANT
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel {
        PictureViewModel(get())
    }
}

val repositoryModule = module {
    single {
        PictureRepository(get(), get())
    }
}

val apiModule = module {
    fun providePictureApi(retrofit: Retrofit) : PictureApi {
        return retrofit.create(PictureApi::class.java)
    }

    single { providePictureApi(get()) }
}

val retrofitModule = module {
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl("https://pixabay.com/")
            .build()
    }

    single { provideRetrofit() }
}

val databaseModule = module {

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "database")
        .fallbackToDestructiveMigration()
        .build()
    }

    fun providePictureDao(database: AppDatabase): PictureDao {
        return database.pictureDao
    }

    single { providePictureDao(get()) }
}