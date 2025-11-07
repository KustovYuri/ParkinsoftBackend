package com.parkinsoft.backend.models.model

data class TestResultModel(
    val testQuestion: String,
    val testAnswer: String,
    val testScore: Int,
    val testMaxScope: Int
)
