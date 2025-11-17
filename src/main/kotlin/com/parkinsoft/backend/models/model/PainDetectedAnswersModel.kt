package com.parkinsoft.backend.models.model

data class PainDetectedRequest(
    val testPreviewId: Long,
    val singleAnswers: List<PainDetectedTestQuestions.SingleAnswer>,
    val humanPoints: List<PainDetectedTestQuestions.HumanPoint>,
    val sliderAnswers: List<PainDetectedTestQuestions.Slider>,
    val graphicAnswers: List<PainDetectedTestQuestions.Graphic>
)

sealed interface PainDetectedTestQuestions {
    data class SingleAnswer(
        val id: Long,
        val question: String,
        val answers: List<String>,
        val selectedAnswer: String = ""
    ): PainDetectedTestQuestions

    data class HumanPoint(
        val id: Long,
        val type: HumanImageType,
        val question: String,
        val selectedPoints: List<Int> = emptyList(),
    ): PainDetectedTestQuestions

    data class Slider(
        val id: Long,
        val sliderAnswers: List<Pair<String, Int>>,
    ): PainDetectedTestQuestions

    data class Graphic(
        val id: Long,
        val question: String,
        val graphicVariant: List<Pair<Int, String>>,
        val selectedVariant: String = ""
    ): PainDetectedTestQuestions
}

enum class HumanImageType {
    HEAD, BACK
}