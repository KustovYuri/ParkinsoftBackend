package com.parkinsoft.backend.repository

import com.parkinsoft.backend.models.entity.TestNativeGraphicAnswer
import com.parkinsoft.backend.models.entity.TestNativeHumanPointAnswer
import com.parkinsoft.backend.models.entity.TestNativeSingleAnswer
import com.parkinsoft.backend.models.entity.TestNativeSliderAnswer
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TestNativeGraphicAnswerRepository : JpaRepository<TestNativeGraphicAnswer, Long> {
    fun findByTestPreviewId(testPreviewId: Long): List<TestNativeGraphicAnswer>

    @Modifying
    @Transactional
    @Query("DELETE FROM TestNativeGraphicAnswer ta WHERE ta.testPreviewId = :previewId")
    fun deleteAllByTestPreviewId(@Param("previewId") previewId: Long)
}

interface TestNativeHumanPointAnswerRepository : JpaRepository<TestNativeHumanPointAnswer, Long> {
    fun findByTestPreviewId(testPreviewId: Long): List<TestNativeHumanPointAnswer>

    @Modifying
    @Transactional
    @Query("DELETE FROM TestNativeHumanPointAnswer ta WHERE ta.testPreviewId = :previewId")
    fun deleteAllByTestPreviewId(@Param("previewId") previewId: Long)
}

interface TestNativeSingleAnswerRepository : JpaRepository<TestNativeSingleAnswer, Long> {
    fun findByTestPreviewId(testPreviewId: Long): List<TestNativeSingleAnswer>

    @Modifying
    @Transactional
    @Query("DELETE FROM TestNativeSingleAnswer ta WHERE ta.testPreviewId = :previewId")
    fun deleteAllByTestPreviewId(@Param("previewId") previewId: Long)
}

interface TestNativeSliderAnswerRepository : JpaRepository<TestNativeSliderAnswer, Long> {
    fun findByTestPreviewId(testPreviewId: Long): List<TestNativeSliderAnswer>

    @Modifying
    @Transactional
    @Query("DELETE FROM TestNativeSliderAnswer ta WHERE ta.testPreviewId = :previewId")
    fun deleteAllByTestPreviewId(@Param("previewId") previewId: Long)
}

