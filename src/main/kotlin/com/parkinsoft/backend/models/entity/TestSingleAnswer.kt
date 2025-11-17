package com.parkinsoft.backend.models.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class TestSingleAnswer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val testPreviewId: Long,
    val questionId: Long,
    val testAnswer: String,
    val isSelected: Boolean,
    val answerPoint: Int,
)
