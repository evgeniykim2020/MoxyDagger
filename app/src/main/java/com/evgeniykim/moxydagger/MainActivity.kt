package com.evgeniykim.moxydagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.evgeniykim.moxydagger.mvp.BaseActivity
import com.evgeniykim.moxydagger.mvp.MainView
import javax.inject.Inject

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    override fun test() {
        Toast.makeText(this, "Bingo!", Toast.LENGTH_SHORT).show()
    }

    @InjectPresenter
    @Inject
    override lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}