package ru.gorshenev.testcountries.ui.countries

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.gorshenev.testcountries.data.repository.CountriesRepository


class CountriesViewModel(private val repository: CountriesRepository) : ViewModel() {
    private val _states: MutableStateFlow<CountriesState> = MutableStateFlow(CountriesState.Loading)

    val states: Flow<CountriesState>
        get() = _states

    init {
        loadCountries()
    }

    fun loadCountries() {
        viewModelScope.launch {
            try {
                _states.emit(CountriesState.Loading)
                val items = repository.getAllCountries().map { it.toUi() }
                _states.emit(CountriesState.Content(items))
            } catch (e: Exception) {
                Log.d("qwe", "loadCountries: ${e.stackTraceToString()}")
                _states.emit(CountriesState.Error)
            }
        }
    }

    class Factory(private val repo: CountriesRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CountriesViewModel(repo) as T
        }
    }
}
