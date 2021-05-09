package hu.bme.aut.pribelszki.covidio.screen.country.list.adapter

import androidx.recyclerview.widget.DiffUtil
import hu.bme.aut.pribelszki.covidio.domain.model.CountryListItem

object CountryListComparator : DiffUtil.ItemCallback<CountryListItem>() {

    override fun areItemsTheSame(oldItem: CountryListItem, newItem: CountryListItem): Boolean {
        return oldItem.id == newItem.id
            }

    override fun areContentsTheSame(oldItem: CountryListItem, newItem: CountryListItem): Boolean {
        return oldItem == newItem
    }

}