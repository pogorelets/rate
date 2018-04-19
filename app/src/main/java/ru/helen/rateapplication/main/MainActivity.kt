package ru.helen.rateapplication.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import ru.helen.rateapplication.App
import ru.helen.rateapplication.R
import ru.helen.rateapplication.model.Stock
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Contract.ViewRate {
    lateinit var adapter: MainAdapter
    @Inject
    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)
        App.instance.initMainComponent(this).inject(this)

        rvRate.layoutManager = LinearLayoutManager(this)
        rvRate.setHasFixedSize(true)
        adapter = MainAdapter()
        rvRate.adapter = adapter
        presenter.getRates()


    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun updateListRate(stoks: List<Stock>) {
        adapter.swapData(stoks)
    }

    override fun onDestroy() {
        super.onDestroy()
        App.instance.destroyMainComponent()
    }
}
