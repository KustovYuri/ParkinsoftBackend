package com.parkinsoft.backend.service

import com.parkinsoft.backend.models.entity.Patient
import com.parkinsoft.backend.models.mappers.convertToPatientShortModel
import com.parkinsoft.backend.models.model.ShortPatientModel
import com.parkinsoft.backend.repository.PatientRepository
import com.parkinsoft.backend.repository.TestPreviewRepository
import org.springframework.stereotype.Service

@Service
class PatientService(
    private val patientRepository: PatientRepository,
    private val testPreviewRepository: TestPreviewRepository
) {
    fun getAll(): List<Patient> = patientRepository.findAll()

    fun getById(id: Long): Patient? = patientRepository.findById(id).orElse(null)

    fun getShortPatientById(patientId: Long): ShortPatientModel {
        val previewTests = testPreviewRepository.findAllByPatientId(patientId)
        return patientRepository.findById(patientId).get().convertToPatientShortModel(previewTests)
    }

    fun create(user: Patient): Patient = patientRepository.save(user)

    fun delete(id: Long) = patientRepository.deleteById(id)
}