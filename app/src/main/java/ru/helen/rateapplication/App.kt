package ru.helen.rateapplication

import android.app.Application
import ru.helen.rateapplication.di.*
import ru.helen.rateapplication.main.MainActivity
import ru.helen.rateapplication.di.DaggerAppComponent

/**
 * Application
 */
class App: Application() {
    private lateinit var appComponent: AppComponent
    private var mainComponent: MainComponent? = null

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext)).build()
    }

    fun initMainComponent(activity: MainActivity): MainComponent {
        mainComponent = appComponent.getMainComponent(MainModule(activity))
        return mainComponent as MainComponent
    }

    fun destroyMainComponent(){
        mainComponent = null
    }
}