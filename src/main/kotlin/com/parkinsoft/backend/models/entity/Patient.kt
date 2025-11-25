package com.parkinsoft.backend.models.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Patient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val doctorId: Long,
    val name: String,
    val secondName: String,
    val middleName: String,
    val phoneNumber: String,
    val sex: Boolean,
    val birthDate: String,
    val diagnosis: String,
    val dateReceipt: String,
    val stateHealth: String,
    val onTreatments: Boolean,
    val lastDateAllTestsRequest: String? = null
)
