package com.mk.recyclerviewtask.presentation.application

import android.app.Application
import com.mk.recyclerviewtask.presentation.application.di.ApplicationComponent
import com.mk.recyclerviewtask.presentation.application.di.DaggerApplicationComponent

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationComponent.create(this)
    }
}