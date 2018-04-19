package ru.helen.rateapplication.di

import dagger.Subcomponent
import ru.helen.rateapplication.main.MainActivity

/**
 * MainComponent
 */
@MainScope
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}