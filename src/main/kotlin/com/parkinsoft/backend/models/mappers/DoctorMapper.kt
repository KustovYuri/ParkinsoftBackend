package com.parkinsoft.backend.models.mappers

import com.parkinsoft.backend.models.entity.Doctor
import com.parkinsoft.backend.models.entity.Patient
import com.parkinsoft.backend.models.model.DoctorWithPatientsModel
import com.parkinsoft.backend.models.model.PatientModel

fun Doctor.convertToDoctorWithPatientModel(doctorPatients: List<PatientModel>): DoctorWithPatientsModel {
    return DoctorWithPatientsModel(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        middleName = this.middleName,
        patients = doctorPatients
    )
}