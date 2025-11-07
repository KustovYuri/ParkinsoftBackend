package com.parkinsoft.backend.models.model


data class AllTestsModel(
    val id: Long? = null,
    val testPreviewId: Long,
    val testQuestion: String,
    val testsAnswers: List<AllTestAnswerModel>
)

data class AllTestAnswerModel(
    val id: Long? = null,
    val testAnswer: String,
    val answerPoint: Int,
)