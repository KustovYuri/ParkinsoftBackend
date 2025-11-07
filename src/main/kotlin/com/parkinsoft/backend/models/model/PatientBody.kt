package com.parkinsoft.backend.models.model

data class PatientBody(
    val doctorId: Long,
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val age: Int,
    val phoneNumber: String,
    val birthdayDate: String,
    val diagnosis: String,
    val onTreatment: Boolean,
    val unreadTests: Int,
    val sex: Boolean,
    val dailyTests: List<String>?,
    val controlTests: List<String>?
)