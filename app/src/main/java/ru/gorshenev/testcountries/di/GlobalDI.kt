package ru.gorshenev.testcountries.di

import kotlinx.coroutines.Dispatchers
import ru.gorshenev.testcountries.data.network.CountriesApi
import ru.gorshenev.testcountries.data.network.NetworkService
import ru.gorshenev.testcountries.data.repository.CountriesRepository

object GlobalDI {

    private val api: CountriesApi = NetworkService.api

    private val dispatcher = Dispatchers.IO

    val repository: CountriesRepository = CountriesRepository(api, dispatcher)

}