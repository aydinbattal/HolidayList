package com.profjk.holidaylist.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.profjk.holidaylist.network.Holiday
import com.profjk.holidaylist.network.HolidaysApi
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * HolidayList created by aydin
 * student ID : 991521740
 * on 10/12/20 */

class HolidayViewModel : ViewModel() {

    private val holidays = MutableLiveData<List<Holiday>>()

    val response: MutableLiveData<List<Holiday>>
        get() = holidays
    
    fun getHolidayInfo(apiUrl: String){
        viewModelScope.launch{
            try{
                val holidays = HolidaysApi.RETROFIT_SERVICE_HOLIDAY.retrieveResponse(apiUrl)
                this@HolidayViewModel.holidays.postValue(holidays)
            }catch (ex: Exception){
                Log.e("HolidayViewModel", ex.localizedMessage)
            }
        }
    }
}