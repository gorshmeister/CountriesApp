package ru.gorshenev.testcountries.data

import retrofit2.http.GET

interface CountriesApi {

    @GET("all")
    suspend fun getAllCountries(): CountryRemote
}