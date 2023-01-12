package ru.gorshenev.testcountries.countries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.gorshenev.testcountries.R
import ru.gorshenev.testcountries.countries.CountryUi
import ru.gorshenev.testcountries.databinding.ItemCountryBinding

class CountriesAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {

    private var items: List<CountryUi> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val photoView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(photoView).apply {

        }
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemCountryBinding = ItemCountryBinding.bind(itemView)

        fun bind(item: CountryUi) {

        }
    }
}