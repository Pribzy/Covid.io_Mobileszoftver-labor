package hu.bme.aut.pribelszki.covidio.screen.country.list.adapter

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isGone
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.pribelszki.covidio.R
import hu.bme.aut.pribelszki.covidio.domain.model.CountryListItem
import hu.bme.aut.pribelszki.covidio.util.toFormattedString
import kotlinx.android.synthetic.main.recyclerview_country_item.view.*
import timber.log.Timber
import java.time.format.DateTimeFormatter

class CountryListAdapter(val context: Context) :
    ListAdapter<CountryListItem, CountryListAdapter.ViewHolder>(CountryListComparator) {

    var listener: Listener? = null

    interface Listener {
        fun onItemSelected(item: CountryListItem)
        fun onFavouriteTapped(item: CountryListItem, isFavourite: Boolean)
        fun onHealTapped(item: CountryListItem)
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
        holder.confirmedCount.text = item.confirmedCount.toFormattedString()
        holder.recoveredCount.text = item.recoveredCount.toFormattedString()
        holder.deathCount.text = item.deathCount.toFormattedString()
        holder.starImageButton.setBackgroundResource(if (item.isFavourite) R.drawable.star_filled else R.drawable.star_outline)
        holder.healedDateTextView.text = "Gyógyulás időpontja: ${item.healedDate}"
        holder.cardView.setCardBackgroundColor(if (item.isHealed) context.getColor(R.color.teal_200) else context.getColor(R.color.white))
        holder.healedDateTextView.isGone = !item.isHealed
        holder.healImageButton.isGone = item.isHealed
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryName: TextView = itemView.countryNameTextView
        val countryCode: TextView = itemView.countryCodeTextView
        val confirmedCount: TextView = itemView.confirmedTextView
        val recoveredCount: TextView = itemView.recoveredTextView
        val deathCount: TextView = itemView.deathTextView
        val starImageButton: ImageButton = itemView.starImageButton
        val healImageButton: ImageButton = itemView.healImageButton
        val healedDateTextView: TextView = itemView.healedDateTextView
        val cardView: CardView = itemView.cardView
        var item: CountryListItem? = null

        init {
            itemView.setOnClickListener {
                item?.let { listener?.onItemSelected(it) }
                Timber.d("Adapter itemSelected")
            }

            starImageButton.setOnClickListener {
                item?.let { listener?.onFavouriteTapped(it, !it.isFavourite) }
                Timber.d("Favourite selected")
            }

            healImageButton.setOnClickListener {
                item?.let { listener?.onHealTapped(it) }
                Timber.d("Favourite healed")
            }
        }
    }
}