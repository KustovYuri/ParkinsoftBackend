package com.parkinsoft.backend.models.mappers

import com.parkinsoft.backend.database_utils.tests.control.HADS1
import com.parkinsoft.backend.database_utils.tests.control.HADS2
import com.parkinsoft.backend.database_utils.tests.control.LANSS
import com.parkinsoft.backend.database_utils.tests.control.OSVESTRY
import com.parkinsoft.backend.database_utils.tests.dayli.STATE_OF_HEALTH_DIARY
import com.parkinsoft.backend.database_utils.tests.dayli.TEST_STIMULATION_DIARY
import com.parkinsoft.backend.models.entity.TestNativeGraphicAnswer
import com.parkinsoft.backend.models.entity.TestNativeHumanPointAnswer
import com.parkinsoft.backend.models.entity.TestNativeSingleAnswer
import com.parkinsoft.backend.models.entity.TestNativeSliderAnswer
import com.parkinsoft.backend.models.entity.TestSingleAnswer
import com.parkinsoft.backend.models.entity.TestPreview
import com.parkinsoft.backend.models.model.AllTestAnswerModel
import com.parkinsoft.backend.models.model.PainDetectedTestQuestions
import com.parkinsoft.backend.models.model.PatientBody
import com.parkinsoft.backend.models.model.TestAnswerModel
import com.parkinsoft.backend.models.model.TestAnswersDTO
import com.parkinsoft.backend.models.model.ShortTestPreviewModel
import com.parkinsoft.backend.models.model.TestModel
import com.parkinsoft.backend.models.model.TestPreviewModel
import com.parkinsoft.backend.models.model.TestType
import com.parkinsoft.backend.utils.convertToString
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private fun TestSingleAnswer.convertToAllTEstAnswersModel(): AllTestAnswerModel {
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

fun ShortTestPreviewModel.convertToTestResponse(previewId: Long, allUserTestSingleAnswers: List<TestSingleAnswer>): List<TestModel> {
    return this.testQuestions.map { testQuestions ->
        TestModel(
            previewId = previewId,
            questionId = testQuestions.questionId,
            questionName = testQuestions.testQuestion,
            answers = testQuestions.testAnswers.convertToTestAnswersResponse(previewId, allUserTestSingleAnswers, testQuestions.questionId)
        )
    }
}

fun List<TestAnswerModel>.convertToTestAnswersResponse(
    previewId: Long,
    allUserTestSingleAnswers: List<TestSingleAnswer>,
    questionId: Long
): List<TestAnswersDTO> {
    return if (allUserTestSingleAnswers.isEmpty()) {
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
            val selectedAnswer = allUserTestSingleAnswers.find { it.testAnswer == testAnswerModel.testAnswer }
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

fun List<TestAnswersDTO>.mapToGraphicEntity(): List<TestSingleAnswer> {
    return this.map {
        TestSingleAnswer(
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
        when(val testType = TestType.fromValue(it)){
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
            TestType.HADS1 -> {
                HADS1.convertToTestPreviewEntity(
                    patientId = patientId,
                    testDate = LocalDate.now(),
                )
            }
            TestType.HADS2 -> {
                HADS2.convertToTestPreviewEntity(
                    patientId = patientId,
                    testDate = LocalDate.now(),
                )
            }
            TestType.DN4 -> {
                getNativeTestPreview(patientId, testType)
            }
            TestType.PAIN_DETECTED -> {
                getNativeTestPreview(patientId, testType)
            }
            TestType.SF36 -> {
                getNativeTestPreview(patientId, testType)
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

private fun getNativeTestPreview(
    patientId: Long,
    testType: TestType
): TestPreview = TestPreview(
    patientId = patientId,
    testType = testType.value,
    testDate = LocalDate.now().convertToString(),
    testTime = 15,
    questionsCount = 15,
    isCompleted = false,
    isViewed = false,
)

fun List<PainDetectedTestQuestions.Graphic>.mapToGraphicEntity(testPreviewId: Long): List<TestNativeGraphicAnswer> {
    return this.map {
        TestNativeGraphicAnswer(
            testPreviewId = testPreviewId,
            nativeTestId = it.id,
            question = it.question,
            selectedVariant = it.selectedVariant
        )
    }
}

fun List<PainDetectedTestQuestions.SingleAnswer>.mapToSingleAnswerEntity(testPreviewId: Long): List<TestNativeSingleAnswer> {
    return this.map {
        TestNativeSingleAnswer(
            testPreviewId = testPreviewId,
            nativeTestId = it.id,
            question = it.question,
            selectedAnswer = it.selectedAnswer
        )
    }
}

fun List<PainDetectedTestQuestions.Slider>.mapToSliderEntity(testPreviewId: Long): List<TestNativeSliderAnswer> {
    return this.map {
        TestNativeSliderAnswer(
            testPreviewId = testPreviewId,
            nativeTestId = it.id,
            sliderAnswers = it.sliderAnswers
        )
    }
}

fun List<PainDetectedTestQuestions.HumanPoint>.mapToHumanPointEntity(testPreviewId: Long): List<TestNativeHumanPointAnswer> {
    return this.map {
        TestNativeHumanPointAnswer(
            testPreviewId = testPreviewId,
            nativeTestId = it.id,
            question = it.question,
            type = it.type,
            selectedPoints = it.selectedPoints
        )
    }
}
