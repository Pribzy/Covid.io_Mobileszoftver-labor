package hu.bme.aut.pribelszki.covidio.util

fun Int.toRoundedString(): String {
    return if (this > 9999) {
        val roundedNumber = (this/1000)
        "${roundedNumber}k"
    } else {
        this.toString()
    }
}