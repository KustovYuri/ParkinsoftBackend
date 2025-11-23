package com.parkinsoft.backend.service

import com.parkinsoft.backend.models.entity.Doctor
import com.parkinsoft.backend.models.entity.TestPreview
import com.parkinsoft.backend.models.mappers.convertToDoctorPatientsModel
import com.parkinsoft.backend.models.mappers.convertToDoctorWithPatientModel
import com.parkinsoft.backend.models.mappers.convertToLargePatientModel
import com.parkinsoft.backend.models.mappers.convertToPatient
import com.parkinsoft.backend.models.mappers.convertToPreviewList
import com.parkinsoft.backend.models.mappers.convertToTestPreviewModel
import com.parkinsoft.backend.models.model.DoctorWithPatientsModel
import com.parkinsoft.backend.models.model.LargePatientModel
import com.parkinsoft.backend.models.model.PatientBody
import com.parkinsoft.backend.repository.DoctorRepository
import com.parkinsoft.backend.repository.PatientRepository
import com.parkinsoft.backend.repository.TestAnswerRepository
import com.parkinsoft.backend.repository.TestPreviewRepository
import org.springframework.stereotype.Service

@Service
class DoctorService(
    private val doctorRepository: DoctorRepository,
    private val patientRepository: PatientRepository,
    private val testPreviewRepository: TestPreviewRepository,
    private val testAnswerRepository: TestAnswerRepository
) {
    fun getAll(): List<Doctor> = doctorRepository.findAll()

    fun getLargePatientInfo(patientId: Long): LargePatientModel {
        val allTestPreviewModels = testPreviewRepository.findAllCompletedTestPreview(patientId).map {
            val summaryPointsInTest = if (it.isNativeTest) {
                it.score
            } else {
                testAnswerRepository.countSummaryPointsInTest(it.id ?: -1).toInt()
            }
            val maxPoints = if (it.isNativeTest) {
                it.maxSore
            } else {
                it.questionsCount * 4
            }
            it.convertToTestPreviewModel(summaryPointsInTest, maxPoints)
        }
        val patient = patientRepository.findById(patientId).get()

        return patient.convertToLargePatientModel(allTestPreviewModels)
    }

    fun getDoctorWithPatients(id: Long): DoctorWithPatientsModel {
        val doctor: Doctor = doctorRepository.findById(id).get()
        val doctorPatients = patientRepository
            .findAllByDoctorId(doctor.id ?: -1)
            .map { patient ->
                val unreadTestCount = testPreviewRepository.countUnviewedByPatientId(patient.id ?: -1)
                patient.convertToDoctorPatientsModel(unreadTestCount.toInt())
            }

        return doctor.convertToDoctorWithPatientModel(doctorPatients)
    }

    fun createNewPatient(newPatientBody: PatientBody): Long {
        val savedPatient = patientRepository.save(
            newPatientBody.convertToPatient()
        )
        testPreviewRepository.saveAll(
            newPatientBody.convertToPreviewList(savedPatient.id ?: -1)
        )

        return savedPatient.id ?: -1
    }

    fun create(user: Doctor): Doctor = doctorRepository.save(user)

    fun delete(id: Long) = doctorRepository.deleteById(id)
}





