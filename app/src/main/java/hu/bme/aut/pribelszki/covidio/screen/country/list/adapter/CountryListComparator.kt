package hu.bme.aut.pribelszki.covidio.screen.country.list.adapter

import androidx.recyclerview.widget.DiffUtil
import hu.bme.aut.pribelszki.covidio.screen.country.list.model.CountryListPresentationModel

object CountryListComparator : DiffUtil.ItemCallback<CountryListPresentationModel>() {

    override fun areItemsTheSame(oldItem: CountryListPresentationModel, newItem: CountryListPresentationModel): Boolean {
        return oldItem.id == newItem.id
            }

    override fun areContentsTheSame(oldItem: CountryListPresentationModel, newItem: CountryListPresentationModel): Boolean {
        return oldItem == newItem
    }

}