package com.parkinsoft.backend.controller

import com.parkinsoft.backend.models.entity.TestPreview
import com.parkinsoft.backend.models.model.NativeTestRequest
import com.parkinsoft.backend.models.model.PainDetectedRequest
import com.parkinsoft.backend.models.model.TestAnswersDTO
import com.parkinsoft.backend.models.model.TestModel
import com.parkinsoft.backend.models.model.TestResultModel
import com.parkinsoft.backend.models.model.TestType
import com.parkinsoft.backend.service.TestService
import com.parkinsoft.backend.service.TestPreviewService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestsController(
    private val testPreviewService: TestPreviewService,
    private val testService: TestService,
) {
    @PostMapping("saveTestAnswers")
    fun saveTestAnswers(@RequestBody testAnswers: List<TestAnswersDTO>) {
        testService.saveTestAnswers(testAnswers)
    }

    @PostMapping("saveNativeTest")
    fun saveNativeTest(@RequestBody testAnswers: NativeTestRequest) {
        testService.saveNativeTestTestAnswers(testAnswers)
    }

    @GetMapping("allTests/{testPreviewId}/{testType}")
    fun getAllTestsByTestPreviewId(
        @PathVariable testPreviewId: Long,
        @PathVariable testType: String
    ): List<TestModel>{
        val testType = TestType.fromValue(testType)
        return if (testType != null){
            testService.getSingleAnswerTestAllTestByTestPreviewId(testPreviewId, testType)
        } else {
            listOf()
        }
    }

    @GetMapping
    fun getAll(): List<TestPreview> = testPreviewService.getAll()

    @GetMapping("/getResultTests/{testPreviewId}/{testType}")
    fun getAllSuccessfulTestAnswers(
        @PathVariable testPreviewId: Long,
        @PathVariable testType: String
    ): List<TestResultModel> {
        val testType = TestType.fromValue(testType)
        return if (testType != null){
            testService.getAllSuccessfulTestAnswers(testPreviewId, testType)
        } else {
            listOf()
        }
    }


    @PostMapping("allTests")
    fun create(@RequestBody user: TestPreview): TestPreview = testPreviewService.create(user)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = testPreviewService.delete(id)
}