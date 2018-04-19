package ru.helen.rateapplication.main

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_rate.view.*
import ru.helen.rateapplication.R
import ru.helen.rateapplication.model.Stock
import java.util.*

/**
 * MainAdapter.
 */
class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var data: List<Stock> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_rate, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    fun swapData(data: List<Stock>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Stock) = with(itemView) {
            name.text = item.name
            volume.text = item.volume.toString()
            val stramount = item.price.amount.toString()
            val res: String
            if  (stramount.substringAfterLast('.').length >=2){
                res = "${stramount.substringBefore('.')}.${stramount.substringAfterLast('.').substring(0,2)}"
            } else {
                res = "${stramount.substringBefore('.')}.${stramount.substringAfterLast('.').substring(0,1)}${"0"}"

            }
            amount.text = res
        }
    }
}