package com.parkinsoft.backend.models.mappers

import com.parkinsoft.backend.database_utils.tests.control.HADS
import com.parkinsoft.backend.database_utils.tests.control.LANSS
import com.parkinsoft.backend.database_utils.tests.control.OSVESTRY
import com.parkinsoft.backend.database_utils.tests.dayli.STATE_OF_HEALTH_DIARY
import com.parkinsoft.backend.database_utils.tests.dayli.TEST_STIMULATION_DIARY
import com.parkinsoft.backend.models.entity.TestAnswer
import com.parkinsoft.backend.models.entity.TestPreview
import com.parkinsoft.backend.models.model.AllTestAnswerModel
import com.parkinsoft.backend.models.model.PatientBody
import com.parkinsoft.backend.models.model.TestAnswerModel
import com.parkinsoft.backend.models.model.TestAnswersDTO
import com.parkinsoft.backend.models.model.ShortTestPreviewModel
import com.parkinsoft.backend.models.model.TestModel
import com.parkinsoft.backend.models.model.TestPreviewModel
import com.parkinsoft.backend.models.model.TestType
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private fun TestAnswer.convertToAllTEstAnswersModel(): AllTestAnswerModel {
    return AllTestAnswerModel(
        id = id,
        testAnswer = testAnswer,
        answerPoint = answerPoint
    )
}

fun ShortTestPreviewModel.convertToTestPreviewEntity(
    patientId: Long,
    testDate: LocalDate,
    isCompleted: Boolean = false,
    isViewed: Boolean? = null,
): TestPreview {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    val testDateString = testDate.format(formatter)

    return TestPreview(
        patientId = patientId,
        testType = testType.value,
        testDate = testDateString,
        testTime = testTime,
        questionsCount = questionsCount,
        isCompleted = isCompleted,
        isViewed = isViewed,
    )
}

fun ShortTestPreviewModel.convertToTestResponse(previewId: Long, allUserTestAnswers: List<TestAnswer>): List<TestModel> {
    return this.testQuestions.map { testQuestions ->
        TestModel(
            previewId = previewId,
            questionId = testQuestions.questionId,
            questionName = testQuestions.testQuestion,
            answers = testQuestions.testAnswers.convertToTestAnswersResponse(previewId, allUserTestAnswers, testQuestions.questionId)
        )
    }
}

fun List<TestAnswerModel>.convertToTestAnswersResponse(
    previewId: Long,
    allUserTestAnswers: List<TestAnswer>,
    questionId: Long
): List<TestAnswersDTO> {
    return if (allUserTestAnswers.isEmpty()) {
        this.map { testAnswerModel ->
            TestAnswersDTO(
                questionId = questionId,
                previewId = previewId,
                testAnswer = testAnswerModel.testAnswer,
                isSelected = false,
                answerPoint = testAnswerModel.answerPoint,
            )
        }
    } else {
        this.map { testAnswerModel ->
            val selectedAnswer = allUserTestAnswers.find { it.testAnswer == testAnswerModel.testAnswer }
            if (selectedAnswer == null) {
                TestAnswersDTO(
                    questionId = testAnswerModel.questionId,
                    previewId = previewId,
                    testAnswer = testAnswerModel.testAnswer,
                    isSelected = false,
                    answerPoint = testAnswerModel.answerPoint
                )
            } else {
                TestAnswersDTO(
                    questionId = testAnswerModel.questionId,
                    previewId = previewId,
                    testAnswerId = selectedAnswer.id,
                    testAnswer = testAnswerModel.testAnswer,
                    isSelected = true,
                    answerPoint = testAnswerModel.answerPoint
                )
            }
        }
    }
}

fun List<TestAnswersDTO>.mapToEntity(): List<TestAnswer> {
    return this.map {
        TestAnswer(
            id = null,
            questionId = it.questionId,
            testAnswer = it.testAnswer,
            answerPoint = it.answerPoint,
            testPreviewId = it.previewId,
            isSelected = it.isSelected,
        )
    }
}

fun TestPreview.convertToTestPreviewModel(summaryPoints: Int): TestPreviewModel {
    return TestPreviewModel(
        id = this.id,
        patientId = this.patientId,
        testType = this.testType,
        testDate = this.testDate,
        questionsCount = this.questionsCount,
        isViewed = this.isViewed,
        maxPoints = this.questionsCount * 4,
        summaryPoints = summaryPoints,
        progressStatus = summaryPoints > (this.questionsCount * 4) / 2,
        testCompletedDate = testCompletedDate ?: "11.11.1111"
    )
}

fun PatientBody.convertToPreviewList(patientId: Long): List<TestPreview> {
    val dailyTestPreview = this.dailyTests?.map {
        val testType = TestType.fromValue(it)

        when(testType){
            TestType.TEST_STIMULATION_DIARY -> {
                TEST_STIMULATION_DIARY.convertToTestPreviewEntity(
                    patientId = patientId,
                    testDate = LocalDate.now(),
                )

            }
            TestType.STATE_OF_HEALTH_DIARY -> {
                STATE_OF_HEALTH_DIARY.convertToTestPreviewEntity(
                    patientId = patientId,
                    testDate = LocalDate.now(),
                )
            }
            else -> {
                STATE_OF_HEALTH_DIARY.convertToTestPreviewEntity(
                    patientId = patientId,
                    testDate = LocalDate.now(),
                )
            }
        }
    } ?: emptyList()

    val controlTestPreview = this.controlTests?.map {
        val testType = TestType.fromValue(it)

        when(testType){
            TestType.OSVESTRY -> {
                OSVESTRY.convertToTestPreviewEntity(
                    patientId = patientId,
                    testDate = LocalDate.now(),
                )
            }
            TestType.LANSS -> {
                LANSS.convertToTestPreviewEntity(
                    patientId = patientId,
                    testDate = LocalDate.now(),
                )
            }
            TestType.HADS -> {
                HADS.convertToTestPreviewEntity(
                    patientId = patientId,
                    testDate = LocalDate.now(),
                )
            }
            else -> {
                OSVESTRY.convertToTestPreviewEntity(
                    patientId = patientId,
                    testDate = LocalDate.now(),
                )
            }
        }
    } ?: emptyList()

    return dailyTestPreview + controlTestPreview
}
