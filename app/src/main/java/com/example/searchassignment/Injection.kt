package com.example.searchassignment

import com.example.searchassignment.remoteService.MainRepository
import com.example.searchassignment.remoteService.ShowsInterface
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class Injection {

    @Singleton
    @Provides
    fun provideApiService(): ShowsInterface =
        Retrofit.Builder()
            .baseUrl("https://api.tvmaze.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShowsInterface::class.java)

    @Singleton
    @Provides
    fun provideRepository(): MainRepository = MainRepository(provideApiService())
}