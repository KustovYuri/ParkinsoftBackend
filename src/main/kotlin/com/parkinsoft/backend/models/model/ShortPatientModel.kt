package com.parkinsoft.backend.models.model

import com.parkinsoft.backend.models.entity.TestPreview

data class ShortPatientModel(
    val id: Long,
    val testPreview: List<TestPreview>
)
