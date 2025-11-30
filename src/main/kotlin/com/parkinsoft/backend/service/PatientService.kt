package com.parkinsoft.backend.service

import com.parkinsoft.backend.models.entity.Patient
import com.parkinsoft.backend.models.entity.TestPreview
import com.parkinsoft.backend.models.mappers.convertToPatientShortModel
import com.parkinsoft.backend.models.mappers.getNativeTestPreview
import com.parkinsoft.backend.models.model.ShortPatientModel
import com.parkinsoft.backend.models.model.TestType
import com.parkinsoft.backend.repository.PatientRepository
import com.parkinsoft.backend.repository.TestPreviewRepository
import com.parkinsoft.backend.utils.convertStringDateToLocalDate
import com.parkinsoft.backend.utils.convertToString
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Service
class PatientService(
    private val patientRepository: PatientRepository,
    private val testPreviewRepository: TestPreviewRepository
) {
    fun getAll(): List<Patient> = patientRepository.findAll()

    fun getById(id: Long): Patient? = patientRepository.findById(id).orElse(null)

    fun getShortPatientById(patientId: Long): ShortPatientModel {
        val patient = patientRepository.findById(patientId).get()
        val currentDate = LocalDate.now()
        val lastRequestDate = patient.lastDateAllTestsRequest?.let { convertStringDateToLocalDate(it) }

        if (lastRequestDate == null) {
            patientRepository.updateLastRequestDate(patientId, currentDate.convertToString())
        } else if (currentDate > lastRequestDate) {
            val daysCount = ChronoUnit.DAYS.between(lastRequestDate, currentDate)
            val testPreviewList = mutableListOf<TestPreview>()

            for (day in 0..< daysCount) {
                val testStimulationTestPreview = getNativeTestPreview(
                    patientId,
                    TestType.TEST_STIMULATION_DIARY,
                    14,
                    15,
                    currentDate.minusDays(day).convertToString()
                )

                testPreviewList.add(testStimulationTestPreview)
            }

            testPreviewRepository.saveAll(testPreviewList)
            patientRepository.allTestsIsCompleted(patientId, false)
            patientRepository.updateLastRequestDate(patientId, currentDate.convertToString())
        }

        val previewTests = testPreviewRepository.findAllByPatientId(patientId)
        return patientRepository.findById(patientId).get().convertToPatientShortModel(previewTests)
    }

    fun create(user: Patient): Patient = patientRepository.save(user)

    fun delete(id: Long) = patientRepository.deleteById(id)
}