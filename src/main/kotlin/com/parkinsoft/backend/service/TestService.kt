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
import com.parkinsoft.backend.models.model.NativeTestRequest
import com.parkinsoft.backend.models.model.ShortTestPreviewModel
import com.parkinsoft.backend.models.model.TestAnswersDTO
import com.parkinsoft.backend.models.model.TestModel
import com.parkinsoft.backend.models.model.TestResultModel
import com.parkinsoft.backend.models.model.TestType
import com.parkinsoft.backend.repository.PatientRepository
import com.parkinsoft.backend.repository.TestAnswerRepository
import com.parkinsoft.backend.repository.TestNativeCommentAnswerRepository
import com.parkinsoft.backend.repository.TestNativeDisplaySliderAnswerRepository
import com.parkinsoft.backend.repository.TestNativeGraphicAnswerRepository
import com.parkinsoft.backend.repository.TestNativeHumanPointAnswerRepository
import com.parkinsoft.backend.repository.TestNativeSingleAnswerRepository
import com.parkinsoft.backend.repository.TestNativeSliderAnswerRepository
import com.parkinsoft.backend.repository.TestNativeYesNoAnswerRepository
import com.parkinsoft.backend.repository.TestPreviewRepository
import com.parkinsoft.backend.utils.convertToString
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TestService(
    private val patientRepository: PatientRepository,
    private val testAnswerRepository: TestAnswerRepository,
    private val testPreviewRepository: TestPreviewRepository,
    private val testNativeGraphicAnswerRepository: TestNativeGraphicAnswerRepository,
    private val testNativeSingleAnswerRepository: TestNativeSingleAnswerRepository,
    private val testNativeSliderAnswerRepository: TestNativeSliderAnswerRepository,
    private val testNativeHumanPointAnswerRepository: TestNativeHumanPointAnswerRepository,
    private val testNativeYesNoAnswerRepository: TestNativeYesNoAnswerRepository,
    private val testNativeDisplaySliderAnswerRepository: TestNativeDisplaySliderAnswerRepository,
    private val testNativeCommentAnswerRepository: TestNativeCommentAnswerRepository,
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

    fun getAllSuccessfulNativeTestAnswers(testPreviewId: Long): NativeTestRequest {
        testPreviewRepository.markViewedTestPreviewById(testPreviewId)

        val testNativeGraphicAnswers = testNativeGraphicAnswerRepository.findByTestPreviewId(testPreviewId).map { it.convertToRequest() }
        val testNativeSingleAnswers = testNativeSingleAnswerRepository.findByTestPreviewId(testPreviewId).map { it.convertToRequest() }
        val testNativeSliderAnswers = testNativeSliderAnswerRepository.findByTestPreviewId(testPreviewId).map { it.convertToRequest() }
        val testNativeHumanPointAnswers = testNativeHumanPointAnswerRepository.findByTestPreviewId(testPreviewId).map { it.convertToRequest() }
        val testNativeYesNoAnswers = testNativeYesNoAnswerRepository.findByTestPreviewId(testPreviewId).map { it.convertToRequest() }
        val testNativeDisplaySliderAnswers = testNativeDisplaySliderAnswerRepository.findByTestPreviewId(testPreviewId).map { it.convertToRequest() }
        val testNativeCommentAnswers = testNativeCommentAnswerRepository.findByTestPreviewId(testPreviewId).map { it.convertToRequest() }

        return NativeTestRequest(
            testPreviewId = testPreviewId,
            singleAnswers = testNativeSingleAnswers,
            humanPoints = testNativeHumanPointAnswers,
            sliderAnswers = testNativeSliderAnswers,
            graphicAnswers = testNativeGraphicAnswers,
            yesNoAnswers = testNativeYesNoAnswers,
            displaySliderAnswers = testNativeDisplaySliderAnswers,
            commentAnswers = testNativeCommentAnswers,
        )
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

            checkAllControlTestIsCompleted(testPreviewId)
        }
    }

    fun saveNativeTestTestAnswers(testsAnswer: NativeTestRequest) {
        val testPreviewId = testsAnswer.testPreviewId

        testPreviewRepository.markCompletedTestPreviewById(testPreviewId)
        testPreviewRepository.markUnviewedTestPreviewById(testPreviewId)
        testPreviewRepository.updateCompletedDate(testPreviewId, LocalDate.now().convertToString())
        testPreviewRepository.updateMaxScore(testPreviewId, testsAnswer.maxPoints)
        testPreviewRepository.updateScore(testPreviewId, testsAnswer.summaryCount)

        testNativeGraphicAnswerRepository.deleteAllByTestPreviewId(testPreviewId)
        testNativeSingleAnswerRepository.deleteAllByTestPreviewId(testPreviewId)
        testNativeSliderAnswerRepository.deleteAllByTestPreviewId(testPreviewId)
        testNativeHumanPointAnswerRepository.deleteAllByTestPreviewId(testPreviewId)
        testNativeYesNoAnswerRepository.deleteAllByTestPreviewId(testPreviewId)
        testNativeDisplaySliderAnswerRepository.deleteAllByTestPreviewId(testPreviewId)
        testNativeCommentAnswerRepository.deleteAllByTestPreviewId(testPreviewId)

        testsAnswer.graphicAnswers?.let { testNativeGraphicAnswerRepository.saveAll(it.map { it.convertToEntity(testPreviewId)}) }
        testsAnswer.singleAnswers?.let { testNativeSingleAnswerRepository.saveAll(it.map { it.convertToEntity(testPreviewId)}) }
        testsAnswer.sliderAnswers?.let { testNativeSliderAnswerRepository.saveAll(it.map { it.convertToEntity(testPreviewId)}) }
        testsAnswer.humanPoints?.let { testNativeHumanPointAnswerRepository.saveAll(it.map { it.convertToEntity(testPreviewId)}) }
        testsAnswer.yesNoAnswers?.let { testNativeYesNoAnswerRepository.saveAll(it.map { it.convertToEntity(testPreviewId)}) }
        testsAnswer.displaySliderAnswers?.let { testNativeDisplaySliderAnswerRepository.saveAll(it.map { it.convertToEntity(testPreviewId)}) }
        testsAnswer.commentAnswers?.let { testNativeCommentAnswerRepository.saveAll(it.map { it.convertToEntity(testPreviewId)}) }

        checkAllControlTestIsCompleted(testPreviewId)
    }

    private fun checkAllControlTestIsCompleted(testPreviewId: Long) {
        val testPreview = testPreviewRepository.findById(testPreviewId).get()
        val patientId = testPreview.patientId
        val allTests = testPreviewRepository.findAllByPatientId(patientId)

        patientRepository.allTestsIsCompleted(patientId, allTests.all { it.isCompleted })
    }

    fun getAll(): List<TestSingleAnswer> = testAnswerRepository.findAll()

    fun getById(id: Long): TestSingleAnswer? = testAnswerRepository.findById(id).orElse(null)

    fun create(user: TestSingleAnswer): TestSingleAnswer = testAnswerRepository.save(user)

    fun delete(id: Long) = testAnswerRepository.deleteById(id)
}