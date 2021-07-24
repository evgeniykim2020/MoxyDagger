package com.evgeniykim.moxydagger.di

import com.evgeniykim.moxydagger.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @ActivityScope
    @Provides
    fun provideTrack(): String {
        return "Tracking"
    }

    @ActivityScope
    @Provides
    fun providePresenter(): MainPresenter {
        return MainPresenter("I see you")
    }
}