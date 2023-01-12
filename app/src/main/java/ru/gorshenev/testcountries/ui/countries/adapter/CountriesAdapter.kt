package ru.gorshenev.testcountries.ui.countries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.gorshenev.testcountries.R
import ru.gorshenev.testcountries.databinding.ItemCountryBinding
import ru.gorshenev.testcountries.ui.countries.CountryUi

class CountriesAdapter(private val onClick: (CountryUi) -> Unit) :
    RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {

    private var items: List<CountryUi> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(itemView).apply {
            itemView.setOnClickListener { onClick(items[bindingAdapterPosition]) }
        }
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<CountryUi>) {
        this.items = items
        notifyDataSetChanged()
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemCountryBinding = ItemCountryBinding.bind(itemView)

        fun bind(item: CountryUi) {
            with(binding) {
                Glide.with(itemView).load(item.flagUrl).into(ivFlag)
                tvCountryName.text = item.name
            }
        }
    }
}