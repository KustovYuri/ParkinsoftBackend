package com.parkinsoft.backend.models.entity

import com.parkinsoft.backend.models.model.HumanImageType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class SingleAnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val testId: Long,
    val selectedAnswer: String,
    val score: Int
)

@Entity
data class HumanPointsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val testId: Long,
    val type: String,
    @Column(columnDefinition = "integer[]")
    val selectedPoints: List<Int>,
    val score: Int
)

@Entity
data class SliderAnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val testId: Long,
    val questionId: Long,
    val sliderValue: Int,
    val score: Int
)

@Entity
data class GraphicAnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val testId: Long,
    val selectedVariant: String = "",
    val score: Int
)

@Entity
data class YesNoAnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val testId: Long,
    val questionId: Long,
    val answer: Boolean,
    val score: Int
)

@Entity
data class DisplaySliderAnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val testId: Long,
    val sliderValue: Int = 0,
    val score: Int
)

@Entity
data class CommentAnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val testId: Long,
    val comment: String = ""
)