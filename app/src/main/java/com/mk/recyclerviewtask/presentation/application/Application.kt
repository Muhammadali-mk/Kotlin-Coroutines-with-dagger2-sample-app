package com.mk.recyclerviewtask.presentation.application

import android.app.Application
import com.mk.recyclerviewtask.presentation.application.di.DaggerApplicationComponent
import javax.inject.Inject

class Application @Inject constructor() : Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder().build().injectApp(this)
    }

}