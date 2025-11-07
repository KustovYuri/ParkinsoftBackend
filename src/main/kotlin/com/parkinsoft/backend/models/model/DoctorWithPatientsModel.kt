package com.parkinsoft.backend.models.model


data class DoctorWithPatientsModel(
    val id: Long? = null,
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val patients: List<PatientModel>
)
