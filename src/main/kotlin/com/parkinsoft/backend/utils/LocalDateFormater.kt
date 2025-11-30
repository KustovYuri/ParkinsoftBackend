package com.parkinsoft.backend.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val localDateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
private val localDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

fun LocalDate.convertToString(): String {
    return this.format(localDateFormatter)
}

fun convertStringDateToLocalDate(stringDate: String): LocalDate {
    return LocalDate.parse(stringDate, localDateFormatter)
}

fun LocalDateTime.convertToString(): String =
    this.format(localDateTimeFormatter)

fun convertStringDateToLocalDateTime(stringDateTime: String): LocalDateTime =
    LocalDateTime.parse(stringDateTime, localDateTimeFormatter)