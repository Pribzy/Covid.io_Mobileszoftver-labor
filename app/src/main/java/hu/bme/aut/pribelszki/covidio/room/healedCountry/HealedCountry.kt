package hu.bme.aut.pribelszki.covidio.room.healedCountry

import androidx.room.ColumnInfo;
import androidx.room.Entity
import androidx.room.PrimaryKey;
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "healed")
class HealedCountry(
    @PrimaryKey var id: String,
    @ColumnInfo(name = "healedDate") var healedDate: String
)
