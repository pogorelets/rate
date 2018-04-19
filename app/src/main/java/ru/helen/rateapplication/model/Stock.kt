package ru.helen.rateapplication.model

/**
 * Model Stock
 */
data class Stock(
   val name : String,
   val price: Price,
   val volume: Int
)