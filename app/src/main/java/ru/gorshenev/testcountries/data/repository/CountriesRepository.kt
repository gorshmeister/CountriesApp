package ru.gorshenev.testcountries.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.gorshenev.testcountries.data.network.CountriesApi
import ru.gorshenev.testcountries.data.network.CountryRemote

class CountriesRepository(
    private val api: CountriesApi,
    private val dispatcher: CoroutineDispatcher
) {

    suspend fun getAllCountries(): List<CountryRemote> = withContext(dispatcher) {
        api.getAllCountries()
    }

}