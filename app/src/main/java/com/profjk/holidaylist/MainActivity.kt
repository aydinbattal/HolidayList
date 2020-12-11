package com.profjk.holidaylist

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var countries : Array<String> = arrayOf("Canada", "USA", "Brazil", "Japan", "Netherlands")
    private var countryCodes : Array<String> = arrayOf("CA", "US", "BR", "JP", "NL")
    private var baseUrl = "https://date.nager.at/api/v2/publicholidays/2021/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.initializeSpinner()
    }

    private fun initializeSpinner(){
        val titlesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        titlesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnCountries.adapter = titlesAdapter
    }

}