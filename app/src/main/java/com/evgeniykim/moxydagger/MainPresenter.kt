package com.evgeniykim.moxydagger

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.evgeniykim.moxydagger.mvp.MainView

@InjectViewState
class MainPresenter(private val data: String): MvpPresenter<MainView>() {

    fun asd(){
        viewState.test()
    }
}