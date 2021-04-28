package hu.bme.aut.pribelszki.covidio.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun formattedNow(): String {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")).toString()
}