package com.parkinsoft.backend.models.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class TestPreview(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val patientId: Long,
    val testType: String,
    val testDate: String,
    val testTime: Int,
    val questionsCount: Int,
    val isCompleted: Boolean,
    val isViewed: Boolean? = null,
    val testCompletedDate: String? = null,
    val maxSore: Int,
    val score: Int,
    val isNativeTest: Boolean
)
