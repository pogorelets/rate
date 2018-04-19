package ru.helen.rateapplication.main

import android.util.Log
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ru.helen.rateapplication.model.Responce



/**
 * Presenter
 */
class Presenter(val view: Contract.ViewRate, val interactor: Contract.Interactor){
    lateinit var observer: Observable<Responce>
    fun getRates(){
        observer =interactor.getRate()
        observer.subscribe({response -> view.updateListRate(response.stock)}, {throwable -> })
    }

    fun unsubscribe(){
        observer.unsubscribeOn(Schedulers.io())
    }
}