package com.martinez.erick.ratingmovies.core.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.martinez.erick.ratingmovies.features.randomrating.presentation.viewmodels.RandomRatingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/

@Module
interface ViewModelModule {

    @Binds
    fun provideFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RandomRatingViewModel::class)
    fun bindMap(viewModel: RandomRatingViewModel): ViewModel

}