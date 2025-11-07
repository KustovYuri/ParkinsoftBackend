package com.parkinsoft.backend.models.model

data class TestPreviewModel(
    val id: Long? = null,
    val patientId: Long,
    val testType: String,
    val testDate: String,
    val questionsCount: Int,
    val isViewed: Boolean? = null,
    val maxPoints: Int,
    val summaryPoints: Int,
    val progressStatus: Boolean,
    val testCompletedDate: String
)
