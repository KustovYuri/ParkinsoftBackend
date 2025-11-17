package com.parkinsoft.backend.models.entity

import com.parkinsoft.backend.models.model.HumanImageType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class TestNativeHumanPointAnswer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val nativeTestId: Long,
    val type: HumanImageType,
    val question: String,
    val selectedPoints: List<Int>,
)