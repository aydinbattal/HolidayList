package com.profjk.holidaylist.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

/*
User jigishapatel
Student ID M05038
Name Jigisha Patel
Date 2020-12-08
*/
private var baseUrl = "https://date.nager.at/api/v2/publicholidays/2021/"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder().baseUrl(baseUrl)
    .addConverterFactory(MoshiConverterFactory.create(moshi)).build()

interface HolidayApiService {
    @GET
    suspend fun retrieveResponse(@Url apiUrl: String) : List<Holiday>
}

object HolidaysApi{
    val RETROFIT_SERVICE_HOLIDAY : HolidayApiService by lazy {
        retrofit.create(HolidayApiService::class.java)
    }
}