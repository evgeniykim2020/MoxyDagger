package com.evgeniykim.moxydagger.mvp

import com.arellomobile.mvp.MvpPresenter

abstract class BasePresenter<V : Presentable> : MvpPresenter<V>() {
}