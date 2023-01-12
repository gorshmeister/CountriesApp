package ru.gorshenev.testcountries.ui.countryinfo

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import ru.gorshenev.testcountries.R
import ru.gorshenev.testcountries.databinding.FragmentInfoBinding

class CountryInfoFragment : Fragment(R.layout.fragment_info) {
    private val binding: FragmentInfoBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val flagUrl = arguments?.getString(ARG_FLAG_URL).orEmpty()
            Glide.with(view).load(flagUrl).into(ivFlag)
            layoutName.tvValue.text = arguments?.getString(ARG_NAME).orEmpty()
            layoutName.tvName.text = getString(R.string.country_name)
            layoutRegion.tvValue.text = arguments?.getString(ARG_REGION).orEmpty()
            layoutRegion.tvName.text = getString(R.string.region)
            layoutCapital.tvValue.text = arguments?.getString(ARG_CAPITAL).orEmpty()
            layoutCapital.tvName.text = getString(R.string.capital)
            layoutCurrency.tvValue.text = arguments?.getStringArray(ARG_CURRENCIES).orEmpty().joinToString()
            layoutCurrency.tvName.text = getString(R.string.currency)
            layoutTimezone.tvValue.text = arguments?.getStringArray(ARG_TIMEZONES).orEmpty().joinToString()
            layoutTimezone.tvName.text = getString(R.string.timezone)
        }
    }

    companion object {
        private const val ARG_NAME: String = "ARG_NAME"
        private const val ARG_REGION: String = "ARG_REGION"
        private const val ARG_CAPITAL: String = "ARG_CAPITAL"
        private const val ARG_FLAG_URL: String = "ARG_FLAG_URL"
        private const val ARG_CURRENCIES: String = "ARG_CURRENCIES"
        private const val ARG_TIMEZONES: String = "ARG_TIMEZONES"

        fun newInstance(
            name: String,
            region: String,
            capital: String,
            flagUrl: String,
            currencies: List<String>,
            timeZones: List<String>
        ): CountryInfoFragment {
            return CountryInfoFragment().apply {
                arguments = bundleOf(
                    ARG_NAME to name,
                    ARG_REGION to region,
                    ARG_CAPITAL to capital,
                    ARG_FLAG_URL to flagUrl,
                    ARG_CURRENCIES to currencies.toTypedArray(),
                    ARG_TIMEZONES to timeZones.toTypedArray()
                )
            }
        }
    }
}