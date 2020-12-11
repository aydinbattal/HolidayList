package com.profjk.holidaylist

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.profjk.holidaylist.adapters.HolidayAdapter
import com.profjk.holidaylist.adapters.OnItemClickListener
import com.profjk.holidaylist.network.Holiday
import com.profjk.holidaylist.viewmodels.HolidayViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, OnItemClickListener {
    private val TAG = this@MainActivity.toString()

    private var countries : Array<String> = arrayOf("Canada", "USA", "Brazil", "Japan", "Netherlands")
    private var countryCodes : Array<String> = arrayOf("CA", "US", "BR", "JP", "NL")
    private var baseUrl = "https://date.nager.at/api/v2/publicholidays/2021/"

    private lateinit var holidayViewModel: HolidayViewModel

    private lateinit var rvHolidays : RecyclerView
    private lateinit var viewAdapter: HolidayAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var holidaysList: MutableList<Holiday>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.rvHolidays = findViewById(R.id.rvHolidays)
        this.holidaysList = mutableListOf()

        this.viewAdapter = HolidayAdapter(this.applicationContext, this.holidaysList, this)
        this.rvHolidays.adapter = this.viewAdapter

        this.viewManager = LinearLayoutManager(this.applicationContext)
        this.rvHolidays.layoutManager = this.viewManager

        this.rvHolidays.setHasFixedSize(true)
        this.rvHolidays.addItemDecoration(DividerItemDecoration(this.applicationContext, DividerItemDecoration.VERTICAL))

        holidayViewModel = HolidayViewModel()

        this.initializeSpinner()
    }

    private fun initializeSpinner(){
        val titlesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        titlesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnCountries.adapter = titlesAdapter
        spnCountries.onItemSelectedListener = this@MainActivity
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        this.getHolidayInfo(this.countryCodes[position])
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun getHolidayInfo(countryCode: String){
        val apiUrl = this.baseUrl + countryCode

        Log.e(TAG, "apiUrl : " + apiUrl)

        this.holidayViewModel.getHolidayInfo(apiUrl)

        this.holidayViewModel.response.observe(this, {
            Log.e(TAG, "holiday response : " + it.toString())
            holidaysList.clear()
            holidaysList.addAll(it)
            viewAdapter.notifyDataSetChanged()
        })
    }

    override fun onItemClicked(holiday: Holiday) {
        TODO("Not yet implemented")
    }

}