package com.parkinsoft.backend.models.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class TestAnswer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val testPreviewId: Long,
    val questionId: Long,
    val testAnswer: String,
    val isSelected: Boolean,
    val answerPoint: Int,
)
