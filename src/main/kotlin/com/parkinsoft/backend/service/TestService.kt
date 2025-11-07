package com.parkinsoft.backend.service

import com.parkinsoft.backend.database_utils.tests.dayli.STATE_OF_HEALTH_DIARY
import com.parkinsoft.backend.database_utils.tests.dayli.TEST_STIMULATION_DIARY
import com.parkinsoft.backend.models.entity.TestAnswer
import com.parkinsoft.backend.models.mappers.convertToTestResponse
import com.parkinsoft.backend.models.mappers.mapToEntity
import com.parkinsoft.backend.models.model.ShortTestPreviewModel
import com.parkinsoft.backend.models.model.TestAnswersDTO
import com.parkinsoft.backend.models.model.TestModel
import com.parkinsoft.backend.models.model.TestResultModel
import com.parkinsoft.backend.models.model.TestType
import com.parkinsoft.backend.repository.TestAnswerRepository
import com.parkinsoft.backend.repository.TestPreviewRepository
import com.parkinsoft.backend.utils.convertToString
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TestService(
    private val testAnswerRepository: TestAnswerRepository,
    private val testPreviewRepository: TestPreviewRepository
) {

    fun getTestAllTestByTestPreviewId(testPreviewId: Long, testType: TestType): List<TestModel> {
        val allUserTestAnswers = testAnswerRepository.findByTestPreviewId(testPreviewId)

        return when(testType) {
            TestType.TEST_STIMULATION_DIARY -> {
                TEST_STIMULATION_DIARY.convertToTestResponse(testPreviewId, allUserTestAnswers)
            }
            TestType.STATE_OF_HEALTH_DIARY -> {
                STATE_OF_HEALTH_DIARY.convertToTestResponse(testPreviewId, allUserTestAnswers)
            }
        }
    }

    fun getAllSuccessfulTestAnswers(testPreviewId: Long, testType: TestType): List<TestResultModel> {
        testPreviewRepository.markViewedTestPreviewById(testPreviewId)
        val testAnswers = testAnswerRepository.findByTestPreviewId(testPreviewId)

        return testAnswers.mapNotNull { testAnswer ->
            when(testType) {
                TestType.TEST_STIMULATION_DIARY -> {
                    getTestResultModel(
                        TEST_STIMULATION_DIARY,
                        testAnswer
                    )
                }
                TestType.STATE_OF_HEALTH_DIARY -> {
                    getTestResultModel(
                        STATE_OF_HEALTH_DIARY,
                        testAnswer
                    )
                }
            }
        }
    }

    private fun getTestResultModel(
        shortTestPreviewModel: ShortTestPreviewModel,
        testAnswer: TestAnswer
    ): TestResultModel? {
        val questions = shortTestPreviewModel.testQuestions
        val question = questions.find { it.questionId == testAnswer.questionId }

        question ?: return null

        return TestResultModel(
            testQuestion = question.testQuestion,
            testAnswer = testAnswer.testAnswer,
            testScore = testAnswer.answerPoint,
            testMaxScope = question.testAnswers.size
        )
    }

    fun saveTestAnswers(testsAnswer: List<TestAnswersDTO>) {
        if (testsAnswer.isNotEmpty()) {
            val testPreviewId = testsAnswer[0].previewId
            testPreviewRepository.markCompletedTestPreviewById(testPreviewId)
            testPreviewRepository.markUnviewedTestPreviewById(testPreviewId)
            testPreviewRepository.updateCompletedDate(testPreviewId, LocalDate.now().convertToString())

            testAnswerRepository.deleteAllByTestPreviewId(testPreviewId)
            testAnswerRepository.saveAll(
                testsAnswer.mapToEntity()
            )
        }
    }

    fun getAll(): List<TestAnswer> = testAnswerRepository.findAll()

    fun getById(id: Long): TestAnswer? = testAnswerRepository.findById(id).orElse(null)

    fun create(user: TestAnswer): TestAnswer = testAnswerRepository.save(user)

    fun delete(id: Long) = testAnswerRepository.deleteById(id)
}
