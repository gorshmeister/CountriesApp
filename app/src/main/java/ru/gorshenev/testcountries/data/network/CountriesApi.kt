package ru.gorshenev.testcountries.data.network

import retrofit2.http.GET

interface CountriesApi {

    @GET("all")
    suspend fun getAllCountries(): List<CountryRemote>
}