package com.martinez.erick.ratingmovies.core.di


import android.app.Application
import com.martinez.erick.ratingmovies.core.di.viewmodel.ViewModelModule
import com.martinez.erick.ratingmovies.core.sqlite.RoomDB
import com.martinez.erick.ratingmovies.core.sqlite.RoomProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun injectRoom(application: Application): RoomDB = RoomProvider(application).createDB()

}