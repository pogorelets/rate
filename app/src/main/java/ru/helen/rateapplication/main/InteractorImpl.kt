package ru.helen.rateapplication.main

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.helen.rateapplication.model.Responce
import ru.helen.rateapplication.model.StockAPI
import java.util.concurrent.TimeUnit

/**
 * Interactor.
 */
class InteractorImpl(var api: StockAPI): Contract.Interactor {
    override fun getOneRate(): Single<Responce> {
        return api.getOneListRate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getRepeatRate(): Observable<Responce> {
          return api.getListRate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

               // .repeat(15000)
    }
}