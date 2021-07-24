package com.evgeniykim.moxydagger.mvp

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity<V : Presentable, P : MvpPresenter<V>> : MoxyActivity(), Presentable, HasAndroidInjector {
    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    abstract var presenter: P

    @ProvidePresenter
    fun providePresenter(): P = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return fragmentDispatchingAndroidInjector
    }

//    fun supportFragmentInjector(): AndroidInjector<Any> {
//        return fragmentDispatchingAndroidInjector
//    }
}