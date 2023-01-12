package ru.gorshenev.testcountries.ui.countries

import ru.gorshenev.testcountries.data.network.CountryRemote

sealed class CountriesState {
    object Loading : CountriesState()
    object Error : CountriesState()
    data class Content(val items: List<CountryUi>) : CountriesState()
}

data class CountryUi(
    val name: String,
    val region: String,
    val capital: String,
    val flagUrl: String,
    val currencies: List<String>,
    val timeZones: List<String>,
)

fun CountryRemote.toUi(): CountryUi {
    return CountryUi(
        name = name.orEmpty(),
        region = region.orEmpty(),
        capital = capital.orEmpty(),
        flagUrl = flag?.url.orEmpty() ,
        currencies = currencies.mapNotNull { it.code },
        timeZones = timeZones
    )
}