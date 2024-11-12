package com.sophiemiller.exercisehelperapp.base

import android.app.Application
import com.sophiemiller.exercisehelperapp.data.di.databaseModule
import com.sophiemiller.exercisehelperapp.domain.di.domainModule
import com.sophiemiller.exercisehelperapp.presentation.module.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(databaseModule, domainModule, presentationModule)
        }
    }
}