package com.parkinsoft.backend.models.mappers

import com.parkinsoft.backend.models.entity.Patient
import com.parkinsoft.backend.models.entity.TestPreview
import com.parkinsoft.backend.models.model.LargePatientModel
import com.parkinsoft.backend.models.model.PatientBody
import com.parkinsoft.backend.models.model.PatientModel
import com.parkinsoft.backend.models.model.ShortPatientModel
import com.parkinsoft.backend.models.model.TestPreviewModel
import com.parkinsoft.backend.utils.convertToString
import java.time.LocalDate

fun Patient.convertToPatientShortModel(testsPreview: List<TestPreview>): ShortPatientModel {
    return ShortPatientModel(
        id = this.id ?: -1,
        testPreview = testsPreview
    )
}

fun Patient.convertToDoctorPatientsModel(unreadTests: Int): PatientModel {
    return PatientModel(
        id = id ?: -1,
        doctorId = doctorId,
        name = name,
        secondName = secondName,
        middleName = middleName,
        phoneNumber = phoneNumber,
        sex = sex,
        birthDate = birthDate,
        diagnosis = diagnosis,
        dateReceipt = dateReceipt,
        stateHealth = stateHealth,
        onTreatments = onTreatments,
        unreadTests = unreadTests,
    )
}

fun Patient.convertToLargePatientModel(allTestPreviewModels: List<TestPreviewModel>): LargePatientModel {
    return LargePatientModel(
        id = this.id,
        doctorId = this.doctorId,
        name = this.name,
        secondName = this.secondName,
        middleName = this.middleName,
        sex = this.sex,
        birthDate = this.birthDate,
        diagnosis = this.diagnosis,
        dateReceipt = this.dateReceipt,
        stateHealth = this.stateHealth,
        onTreatments = this.onTreatments,
        testsPreview = allTestPreviewModels,
    )
}

fun PatientBody.convertToPatient(): Patient {
    return Patient(
        doctorId = this.doctorId,
        name = this.firstName,
        secondName = this.lastName,
        middleName = this.middleName,
        phoneNumber = this.phoneNumber,
        sex = this.sex,
        birthDate = this.birthdayDate,
        diagnosis = this.diagnosis,
        dateReceipt = LocalDate.now().convertToString(),
        stateHealth = "Идет на поправку",
        onTreatments = true,
    )
}