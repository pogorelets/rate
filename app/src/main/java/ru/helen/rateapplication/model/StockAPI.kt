package ru.helen.rateapplication.model

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

/**
 * API.
 */
interface StockAPI {
    @GET("stocks.json")
    fun getListRate(): Observable<Responce>
}