package ru.helen.rateapplication.main

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ru.helen.rateapplication.model.Responce



/**
 * Presenter
 */
class Presenter(val view: Contract.ViewRate, val interactor: Contract.Interactor){
    lateinit var observer: Observable<Responce>
    fun getRates(){
        view.showProgress()
        observer =interactor.getRepeatRate()
        observer.subscribe({response -> view.hideProgress()
                                        view.updateListRate(response.stock)
                                        }, {throwable -> view.hideProgress()})
    }

    fun getOnceRate(){
        view.showProgress()
        interactor.getOneRate()
                .subscribe({response -> view.hideProgress()
                                        view.updateListRate(response.stock)}, {throwable -> view.hideProgress() })
    }

    fun unsubscribe(){
        observer.unsubscribeOn(Schedulers.io())
    }
}