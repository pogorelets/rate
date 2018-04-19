package ru.helen.rateapplication.di

import dagger.Component
import javax.inject.Singleton

/**
 * AppComponent
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun getMainComponent(mainModule:MainModule): MainComponent
}