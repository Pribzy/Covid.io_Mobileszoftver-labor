package hu.bme.aut.pribelszki.covidio.room

import androidx.room.ColumnInfo;
import androidx.room.Entity
import androidx.room.PrimaryKey;

@Entity(tableName = "favourites")
class FavouriteCountry(
    @PrimaryKey var id: String,
    @ColumnInfo(name = "countryName") var countryName: String
)
