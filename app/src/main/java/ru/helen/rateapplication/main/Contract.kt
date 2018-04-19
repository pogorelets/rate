package ru.helen.rateapplication.main

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import ru.helen.rateapplication.model.Responce
import ru.helen.rateapplication.model.Stock

/**
 * Contract
 */
interface Contract {
    interface ViewRate{
        fun showProgress()
        fun hideProgress()
        fun updateListRate(stoks: List<Stock>)
    }

    interface Interactor{
        fun getRepeatRate(): Observable<Responce>
        fun getOneRate(): Single<Responce>
    }


}