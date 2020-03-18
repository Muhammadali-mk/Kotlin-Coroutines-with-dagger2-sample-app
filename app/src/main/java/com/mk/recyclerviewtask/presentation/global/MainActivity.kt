package com.mk.recyclerviewtask.presentation.global

import android.os.Bundle
import android.os.PersistableBundle
import com.mk.recyclerviewtask.R
import com.mk.recyclerviewtask.databinding.ActivityMainBinding
import com.mk.recyclerviewtask.presentation.application.Application
import com.mk.recyclerviewtask.presentation.application.di.ApplicationComponent
import com.mk.recyclerviewtask.presentation.global.di.GlobalComponent
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        GlobalComponent.createOrGet(ApplicationComponent.get()).inject(this)
        super.onCreate(savedInstanceState, persistentState)
    }
}
