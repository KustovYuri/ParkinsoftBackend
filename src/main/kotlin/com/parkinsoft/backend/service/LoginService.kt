package com.parkinsoft.backend.service

import com.parkinsoft.backend.models.model.LoginModel
import com.parkinsoft.backend.models.model.Role
import com.parkinsoft.backend.repository.DoctorRepository
import com.parkinsoft.backend.repository.PatientRepository
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val patientRepository: PatientRepository,
    private val doctorRepository: DoctorRepository
) {
    fun loginUser(phoneNumber: String): LoginModel {
        val patient = patientRepository.findFirstByPhoneNumber(phoneNumber)
        val doctor = doctorRepository.findFirstByPhoneNumber(phoneNumber)

        if (patient != null) {
            return LoginModel(
                userId = patient.id ?: -1,
                role = Role.PATIENT
            )
        }

        if (doctor != null) {
            return LoginModel(
                userId = doctor.id ?: -1,
                role = Role.DOCTOR
            )
        }

        return LoginModel(
            userId = -1,
            role = Role.UNKNOWN
        )
    }
}