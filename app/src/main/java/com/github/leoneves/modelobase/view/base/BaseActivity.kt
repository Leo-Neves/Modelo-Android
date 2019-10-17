package com.github.leoneves.modelobase.view.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.leoneves.modelobase.R

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        onCreate()
    }

    protected open fun onCreate(){

    }

    protected open fun getLayoutId(): Int{
        return -1
    }
}
