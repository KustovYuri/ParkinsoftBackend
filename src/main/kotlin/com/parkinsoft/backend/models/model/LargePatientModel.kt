package com.parkinsoft.backend.models.model

data class LargePatientModel(
    val id: Long? = null,
    val doctorId: Long,
    val name: String,
    val secondName: String,
    val middleName: String,
    val sex: Boolean,
    val birthDate: String,
    val diagnosis: String,
    val dateReceipt: String,
    val stateHealth: String,
    val onTreatments: Boolean,
    val testsPreview: List<TestPreviewModel>,
    val lastDateAllTestsRequest: String?,
    val selectedControlTests: List<String>?,
    val dateDischarge: String?,
    val isDischarge: Boolean,
    val allControlTestsIsComplete: Boolean,
    val finalTestsIsSending: Boolean
)
