package com.parkinsoft.backend.models.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class TestNativeSingleAnswer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val nativeTestId: Long,
    val question: String,
    val selectedAnswer: String
)