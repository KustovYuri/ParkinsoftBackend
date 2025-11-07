package com.parkinsoft.backend.models.model

data class TestModel(
    val previewId: Long,
    val questionId: Long,
    val questionName: String,
    val answers: List<TestAnswersDTO>
)

data class TestAnswersDTO(
    val previewId: Long,
    val questionId: Long,
    val testAnswerId: Long? = null,
    val testAnswer: String,
    val isSelected: Boolean,
    val answerPoint: Int,
)
