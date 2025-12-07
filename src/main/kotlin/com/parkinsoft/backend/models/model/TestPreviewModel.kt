package com.parkinsoft.backend.models.model

data class TestPreviewModel(
    val id: Long? = null,
    val patientId: Long,
    val testType: String,
    val testDate: String,
    val questionsCount: Int,
    val isViewed: Boolean? = null,
    val maxPoints: Int,
    val summaryPoints: Int,
    val progressStatus: Boolean,
    val testCompletedDate: String,
    val pf: Float? = null,
    val rp: Float? = null,
    val bp: Float? = null,
    val gh: Float? = null,
    val vt: Float? = null,
    val sf: Float? = null,
    val re: Float? = null,
    val mh: Float? = null,
)
