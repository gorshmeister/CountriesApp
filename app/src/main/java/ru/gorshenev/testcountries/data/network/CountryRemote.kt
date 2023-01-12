package ru.gorshenev.testcountries.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryRemote(
    @SerialName("name")
    val name: String? = null,
    @SerialName("region")
    val region: String? = null,
    @SerialName("capital")
    val capital: String? = null,
    @SerialName("flags")
    val flag: Flag? = null,
    @SerialName("currencies")
    val currencies: List<Currency> = emptyList(),
    @SerialName("timezones")
    val timeZones: List<String> = emptyList()
)

@Serializable
data class Flag(
    @SerialName("png")
    val url: String
)

@Serializable
data class Currency(
    @SerialName("code")
    val code: String? = null,
    @SerialName("symbol")
    val symbol: String? = null
)