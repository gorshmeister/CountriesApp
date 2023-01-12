package ru.gorshenev.testcountries.ui.countries

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.gorshenev.testcountries.R
import ru.gorshenev.testcountries.databinding.FragmentCountriesBinding
import ru.gorshenev.testcountries.di.GlobalDI
import ru.gorshenev.testcountries.ui.countries.adapter.CountriesAdapter

class CountriesFragment : Fragment(R.layout.fragment_countries) {
    private val binding: FragmentCountriesBinding by viewBinding()

    private val viewModel: CountriesViewModel by viewModels {
        CountriesViewModel.Factory(GlobalDI.repository)
    }

    private val adapter: CountriesAdapter = CountriesAdapter(::onCountryClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRefresh.setOnClickListener { viewModel.loadCountries() }
        binding.rvCountries.adapter = adapter
        binding.rvCountries.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayout.VERTICAL
            )
        )

        viewModel.states.onEach(::render).launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun render(state: CountriesState) {
        when (state) {
            is CountriesState.Content -> {
                binding.error.isVisible = false
                binding.progress.isVisible = false
                binding.rvCountries.isVisible = true
                adapter.setItems(state.items)
            }
            CountriesState.Error -> {
                binding.error.isVisible = true
                binding.progress.isVisible = false
                binding.rvCountries.isVisible = false
            }
            CountriesState.Loading -> {
                binding.error.isVisible = false
                binding.progress.isVisible = true
                binding.rvCountries.isVisible = true
            }
        }
    }

    private fun onCountryClick(item: CountryUi) {

    }
}