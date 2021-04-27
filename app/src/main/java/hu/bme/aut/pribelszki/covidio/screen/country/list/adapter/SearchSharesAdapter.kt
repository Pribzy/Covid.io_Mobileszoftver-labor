package hu.bme.aut.pribelszki.covidio.screen.country.list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.pribelszki.covidio.R
import hu.bme.aut.pribelszki.covidio.screen.country.list.model.CountryListPresentationModel
import kotlinx.android.synthetic.main.recyclerview_country_item.view.*

class CountryListAdapter(val context: Context) :
    ListAdapter<CountryListPresentationModel, CountryListAdapter.ViewHolder>(CountryListComparator) {

    var listener: Listener? = null

    interface Listener {
        fun onItemSelected(shareName: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.recyclerview_country_item,
                parent,
                false
            )
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.item = item
        holder.countryName.text = item.countryName
        holder.countryCode.text = "(${item.countryCode})"
        holder.confirmedCount.text = item.confirmedCount.toString()
        holder.recoveredCount.text = item.recoveredCount.toString()
        holder.deathCount.text = item.deathCount.toString()
        holder.starImageButton.setBackgroundResource(if (item.isFavourite) R.drawable.star_filled else R.drawable.star_outline)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryName: TextView = itemView.countryNameTextView
        val countryCode: TextView = itemView.countryCodeTextView
        val confirmedCount: TextView = itemView.confirmedTextView
        val recoveredCount: TextView = itemView.recoveredTextView
        val deathCount: TextView = itemView.deathTextView
        val starImageButton: ImageButton = itemView.starImageButton
        var item: CountryListPresentationModel? = null
    }
}