package ru.gorshenev.testcountries.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryRemote(
    @SerialName("name")
    val name: String,
    @SerialName("region")
    val region: String,
    @SerialName("capital")
    val capital: String,
    @SerialName("flags")
    val flag: Flag,
    @SerialName("currencies")
    val currencies: List<Currency>,
    @SerialName("timezones")
    val timeZones: List<String>
)

@Serializable
data class Flag(
    @SerialName("png")
    val url: String
)

@Serializable
data class Currency(
    @SerialName("code")
    val code: String,
    @SerialName("symbol")
    val symbol: String
)