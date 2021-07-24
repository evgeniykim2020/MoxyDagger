package com.evgeniykim.moxydagger.mvp

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.arellomobile.mvp.MvpDelegate
import dagger.android.support.DaggerAppCompatActivity

@SuppressLint("Registered")
open class MoxyActivity : AppCompatActivity() {
    private var mMvpDelegate: MvpDelegate<out MoxyActivity>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getMvpDelegate()?.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        getMvpDelegate()?.onAttach()
    }

    override fun onRestart() {
        super.onRestart()

        getMvpDelegate()?.onAttach()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        getMvpDelegate()?.onSaveInstanceState(outState)
        getMvpDelegate()?.onDetach()
    }

    override fun onStop() {
        super.onStop()

        getMvpDelegate()?.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()

        getMvpDelegate()?.onDestroyView()

        if (isFinishing) {
            getMvpDelegate()?.onDestroy()
        }
    }

    fun getMvpDelegate(): MvpDelegate<out MoxyActivity>? {
        if (mMvpDelegate == null) {
            mMvpDelegate = MvpDelegate<MoxyActivity>(this)
        }
        return mMvpDelegate
    }
}