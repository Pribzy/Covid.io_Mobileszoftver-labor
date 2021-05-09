package hu.bme.aut.pribelszki.covidio.util

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun formattedNow(): String {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")).toString()
}

val DECIMAL_FORMAT = "###,###.#"

fun formatValue(value: Number, formatString: String): String? {
    val formatSymbols = DecimalFormatSymbols(Locale.ENGLISH)
    formatSymbols.decimalSeparator = '.'
    formatSymbols.groupingSeparator = ' '
    val formatter = DecimalFormat(formatString, formatSymbols)
    return formatter.format(value)
}