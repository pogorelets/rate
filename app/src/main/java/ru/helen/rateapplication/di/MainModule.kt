package ru.helen.rateapplication.di

import dagger.Module
import dagger.Provides
import ru.helen.rateapplication.main.Contract
import ru.helen.rateapplication.main.InteractorImpl
import ru.helen.rateapplication.main.Presenter
import ru.helen.rateapplication.model.StockAPI

/**
 * MainModule.
 */

@Module
class MainModule(val view: Contract.ViewRate) {
    @MainScope
    @Provides
    fun provideView(): Contract.ViewRate = view

    @MainScope
    @Provides
    fun provideInteractor(stockAPI : StockAPI): Contract.Interactor = InteractorImpl(stockAPI)

    @MainScope
    @Provides
    fun providePresenter(view: Contract.ViewRate, interactor: Contract.Interactor): Presenter = Presenter(view,interactor)
}