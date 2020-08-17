package com.yveskalumenoble.architecturecomponents.app.di

import com.yveskalumenoble.architecturecomponents.data.api.PictureApi
import com.yveskalumenoble.architecturecomponents.data.repository.PictureRepository
import com.yveskalumenoble.architecturecomponents.ui.viewmodel.PictureViewModel
import com.yveskalumenoble.architecturecomponents.util.CONSTANT
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
        PictureRepository(get())
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
            .baseUrl("https://pixabay.com/")
            .build()
    }

    single { provideRetrofit() }
}