package com.parkinsoft.backend.models.model

data class ShortTestPreviewModel(
    val testType: TestType,
    val testName: String,
    val testTime: Int,
    val questionsCount: Int,
    val testQuestions: List<TestQuestionModel>
)

data class TestQuestionModel(
    val testQuestion: String,
    val testAnswers: List<TestAnswerModel>,
    val questionId: Long
)

data class TestAnswerModel(
    val questionId: Long,
    val testAnswer: String,
    val answerPoint: Int,
)

enum class TestType(val value: String) {
    TEST_STIMULATION_DIARY("test_stimulation_diary"),
    STATE_OF_HEALTH_DIARY("state_of_health_diary");

    companion object {
        fun fromValue(value: String): TestType? =
            entries.find { it.value == value }
    }
}
