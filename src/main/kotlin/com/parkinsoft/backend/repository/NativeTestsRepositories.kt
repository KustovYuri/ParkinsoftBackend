package com.parkinsoft.backend.repository

import com.parkinsoft.backend.models.entity.CommentAnswerEntity
import com.parkinsoft.backend.models.entity.DisplaySliderAnswerEntity
import com.parkinsoft.backend.models.entity.GraphicAnswerEntity
import com.parkinsoft.backend.models.entity.HumanPointsEntity
import com.parkinsoft.backend.models.entity.SingleAnswerEntity
import com.parkinsoft.backend.models.entity.SliderAnswerEntity
import com.parkinsoft.backend.models.entity.YesNoAnswerEntity
import com.parkinsoft.backend.models.model.CommentAnswerRequest
import com.parkinsoft.backend.models.model.DisplaySliderAnswerRequest
import com.parkinsoft.backend.models.model.GraphicAnswerRequest
import com.parkinsoft.backend.models.model.HumanPointsRequest
import com.parkinsoft.backend.models.model.SingleAnswerRequest
import com.parkinsoft.backend.models.model.SliderAnswerRequest
import com.parkinsoft.backend.models.model.YesNoAnswerRequest
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TestNativeHumanPointAnswerRepository : JpaRepository<HumanPointsEntity, Long> {
    fun findByTestPreviewId(testPreviewId: Long): List<HumanPointsEntity>

    @Modifying
    @Transactional
    @Query("DELETE FROM HumanPointsEntity ta WHERE ta.testPreviewId = :previewId")
    fun deleteAllByTestPreviewId(@Param("previewId") previewId: Long)
}

interface TestNativeSingleAnswerRepository : JpaRepository<SingleAnswerEntity, Long> {
    fun findByTestPreviewId(testPreviewId: Long): List<SingleAnswerEntity>

    @Modifying
    @Transactional
    @Query("DELETE FROM SingleAnswerEntity ta WHERE ta.testPreviewId = :previewId")
    fun deleteAllByTestPreviewId(@Param("previewId") previewId: Long)
}

interface TestNativeSliderAnswerRepository : JpaRepository<SliderAnswerEntity, Long> {
    fun findByTestPreviewId(testPreviewId: Long): List<SliderAnswerEntity>

    @Modifying
    @Transactional
    @Query("DELETE FROM SliderAnswerEntity ta WHERE ta.testPreviewId = :previewId")
    fun deleteAllByTestPreviewId(@Param("previewId") previewId: Long)
}

interface TestNativeGraphicAnswerRepository : JpaRepository<GraphicAnswerEntity, Long> {
    fun findByTestPreviewId(testPreviewId: Long): List<GraphicAnswerEntity>

    @Modifying
    @Transactional
    @Query("DELETE FROM GraphicAnswerEntity ta WHERE ta.testPreviewId = :previewId")
    fun deleteAllByTestPreviewId(@Param("previewId") previewId: Long)
}

interface TestNativeYesNoAnswerRepository : JpaRepository<YesNoAnswerEntity, Long> {
    fun findByTestPreviewId(testPreviewId: Long): List<YesNoAnswerEntity>

    @Modifying
    @Transactional
    @Query("DELETE FROM YesNoAnswerEntity ta WHERE ta.testPreviewId = :previewId")
    fun deleteAllByTestPreviewId(@Param("previewId") previewId: Long)
}

interface TestNativeDisplaySliderAnswerRepository : JpaRepository<DisplaySliderAnswerEntity, Long> {
    fun findByTestPreviewId(testPreviewId: Long): List<DisplaySliderAnswerEntity>

    @Modifying
    @Transactional
    @Query("DELETE FROM DisplaySliderAnswerEntity ta WHERE ta.testPreviewId = :previewId")
    fun deleteAllByTestPreviewId(@Param("previewId") previewId: Long)
}

interface TestNativeCommentAnswerRepository : JpaRepository<CommentAnswerEntity, Long> {
    fun findByTestPreviewId(testPreviewId: Long): List<CommentAnswerEntity>

    @Modifying
    @Transactional
    @Query("DELETE FROM CommentAnswerEntity ta WHERE ta.testPreviewId = :previewId")
    fun deleteAllByTestPreviewId(@Param("previewId") previewId: Long)
}

