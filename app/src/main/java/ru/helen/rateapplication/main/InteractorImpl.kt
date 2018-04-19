package ru.helen.rateapplication.main

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.helen.rateapplication.model.Responce
import ru.helen.rateapplication.model.Stock
import ru.helen.rateapplication.model.StockAPI

/**
 * Interactor.
 */
class InteractorImpl(var api: StockAPI): Contract.Interactor {
    override fun getRate(): Observable<Responce> {
        return api.getListRate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .repeat(10000)
    }
}