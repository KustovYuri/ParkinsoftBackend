package com.parkinsoft.backend.service

import com.parkinsoft.backend.database_utils.tests.control.HADS1
import com.parkinsoft.backend.database_utils.tests.control.HADS2
import com.parkinsoft.backend.database_utils.tests.control.LANSS
import com.parkinsoft.backend.database_utils.tests.control.OSVESTRY
import com.parkinsoft.backend.database_utils.tests.dayli.STATE_OF_HEALTH_DIARY
import com.parkinsoft.backend.database_utils.tests.dayli.TEST_STIMULATION_DIARY
import com.parkinsoft.backend.models.entity.TestSingleAnswer
import com.parkinsoft.backend.models.mappers.convertToTestResponse
import com.parkinsoft.backend.models.mappers.mapToGraphicEntity
import com.parkinsoft.backend.models.mappers.mapToHumanPointEntity
import com.parkinsoft.backend.models.mappers.mapToSliderEntity
import com.parkinsoft.backend.models.mappers.mapToSingleAnswerEntity
import com.parkinsoft.backend.models.model.PainDetectedRequest
import com.parkinsoft.backend.models.model.ShortTestPreviewModel
import com.parkinsoft.backend.models.model.TestAnswersDTO
import com.parkinsoft.backend.models.model.TestModel
import com.parkinsoft.backend.models.model.TestResultModel
import com.parkinsoft.backend.models.model.TestType
import com.parkinsoft.backend.repository.TestAnswerRepository
import com.parkinsoft.backend.repository.TestNativeGraphicAnswerRepository
import com.parkinsoft.backend.repository.TestNativeHumanPointAnswerRepository
import com.parkinsoft.backend.repository.TestNativeSingleAnswerRepository
import com.parkinsoft.backend.repository.TestNativeSliderAnswerRepository
import com.parkinsoft.backend.repository.TestPreviewRepository
import com.parkinsoft.backend.utils.convertToString
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TestService(
    private val testAnswerRepository: TestAnswerRepository,
    private val testPreviewRepository: TestPreviewRepository,
    private val testNativeGraphicAnswerRepository: TestNativeGraphicAnswerRepository,
    private val testNativeSingleAnswerRepository: TestNativeSingleAnswerRepository,
    private val testNativeSliderAnswerRepository: TestNativeSliderAnswerRepository,
    private val testNativeHumanPointAnswerRepository: TestNativeHumanPointAnswerRepository,
) {

    fun getSingleAnswerTestAllTestByTestPreviewId(testPreviewId: Long, testType: TestType): List<TestModel> {
        val allUserTestAnswers = testAnswerRepository.findByTestPreviewId(testPreviewId)

        return when(testType) {
            TestType.TEST_STIMULATION_DIARY -> {
                TEST_STIMULATION_DIARY.convertToTestResponse(testPreviewId, allUserTestAnswers)
            }
            TestType.STATE_OF_HEALTH_DIARY -> {
                STATE_OF_HEALTH_DIARY.convertToTestResponse(testPreviewId, allUserTestAnswers)
            }
            TestType.OSVESTRY -> {
                OSVESTRY.convertToTestResponse(testPreviewId, allUserTestAnswers)
            }
            TestType.LANSS -> {
                LANSS.convertToTestResponse(testPreviewId, allUserTestAnswers)
            }
            TestType.HADS1 -> {
                HADS1.convertToTestResponse(testPreviewId, allUserTestAnswers)
            }
            TestType.HADS2 -> {
                HADS2.convertToTestResponse(testPreviewId, allUserTestAnswers)
            }
            else -> {
                HADS1.convertToTestResponse(testPreviewId, allUserTestAnswers)
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
                TestType.OSVESTRY -> {
                    getTestResultModel(
                        OSVESTRY,
                        testAnswer
                    )
                }
                TestType.LANSS -> {
                    getTestResultModel(
                        LANSS,
                        testAnswer
                    )
                }
                TestType.HADS1 -> {
                    getTestResultModel(
                        HADS1,
                        testAnswer
                    )
                }
                TestType.HADS2 -> {
                    getTestResultModel(
                        HADS2,
                        testAnswer
                    )
                }
                else -> {
                    getTestResultModel(
                        HADS1,
                        testAnswer
                    )
                }
            }
        }
    }

    private fun getTestResultModel(
        shortTestPreviewModel: ShortTestPreviewModel,
        testSingleAnswer: TestSingleAnswer
    ): TestResultModel? {
        val questions = shortTestPreviewModel.testQuestions
        val question = questions.find { it.questionId == testSingleAnswer.questionId }

        question ?: return null

        return TestResultModel(
            testQuestion = question.testQuestion,
            testAnswer = testSingleAnswer.testAnswer,
            testScore = testSingleAnswer.answerPoint,
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
                testsAnswer.mapToGraphicEntity()
            )
        }
    }

    fun savePainDetectedTestAnswers(testsAnswer: PainDetectedRequest) {
        val testPreviewId = testsAnswer.testPreviewId

        testPreviewRepository.markCompletedTestPreviewById(testPreviewId)
        testPreviewRepository.markUnviewedTestPreviewById(testPreviewId)
        testPreviewRepository.updateCompletedDate(testPreviewId, LocalDate.now().convertToString())

        testNativeGraphicAnswerRepository.deleteAllByTestPreviewId(testPreviewId)
        testNativeSingleAnswerRepository.deleteAllByTestPreviewId(testPreviewId)
        testNativeSliderAnswerRepository.deleteAllByTestPreviewId(testPreviewId)
        testNativeHumanPointAnswerRepository.deleteAllByTestPreviewId(testPreviewId)

        testNativeGraphicAnswerRepository.saveAll(testsAnswer.graphicAnswers.mapToGraphicEntity(testPreviewId))
        testNativeSingleAnswerRepository.saveAll(testsAnswer.singleAnswers.mapToSingleAnswerEntity(testPreviewId))
        testNativeSliderAnswerRepository.saveAll(testsAnswer.sliderAnswers.mapToSliderEntity(testPreviewId))
        testNativeHumanPointAnswerRepository.saveAll(testsAnswer.humanPoints.mapToHumanPointEntity(testPreviewId))
    }

    fun getAll(): List<TestSingleAnswer> = testAnswerRepository.findAll()

    fun getById(id: Long): TestSingleAnswer? = testAnswerRepository.findById(id).orElse(null)

    fun create(user: TestSingleAnswer): TestSingleAnswer = testAnswerRepository.save(user)

    fun delete(id: Long) = testAnswerRepository.deleteById(id)
}