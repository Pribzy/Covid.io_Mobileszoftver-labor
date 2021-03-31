package hu.bme.aut.pribelszki.covidio.room

import androidx.room.ColumnInfo;
import androidx.room.Entity
import androidx.room.PrimaryKey;

@Entity(tableName = "favourites")
class FavouriteCountry(
    @PrimaryKey(autoGenerate = true) var countryId: Long?,
    @ColumnInfo(name = "countryName") var countryName: String
)
