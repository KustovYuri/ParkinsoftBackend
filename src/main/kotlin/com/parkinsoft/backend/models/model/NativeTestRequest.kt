package com.parkinsoft.backend.models.model

import com.parkinsoft.backend.models.entity.CommentAnswerEntity
import com.parkinsoft.backend.models.entity.DisplaySliderAnswerEntity
import com.parkinsoft.backend.models.entity.GraphicAnswerEntity
import com.parkinsoft.backend.models.entity.HumanPointsEntity
import com.parkinsoft.backend.models.entity.SingleAnswerEntity
import com.parkinsoft.backend.models.entity.SliderAnswerEntity
import com.parkinsoft.backend.models.entity.YesNoAnswerEntity

data class NativeTestRequest(
    val testPreviewId: Long,
    val singleAnswers: List<SingleAnswerRequest>?,
    val humanPoints: List<HumanPointsRequest>?,
    val sliderAnswers: List<SliderAnswerRequest>?,
    val graphicAnswers: List<GraphicAnswerRequest>?,
    val yesNoAnswers: List<YesNoAnswerRequest>?,
    val displaySliderAnswers: List<DisplaySliderAnswerRequest>?,
    val commentAnswers: List<CommentAnswerRequest>?,
)

data class SingleAnswerRequest(
    val testId: Long,
    val selectedAnswer: String,
    val score: Int
) {
    fun convertToEntity(testPreviewId: Long): SingleAnswerEntity {
        return SingleAnswerEntity(
            testPreviewId = testPreviewId,
            testId = this.testId,
            selectedAnswer = selectedAnswer,
            score = score,
        )
    }
}

data class HumanPointsRequest(
    val testId: Long,
    val type: HumanImageType,
    val selectedPoints: List<Int>,
    val score: Int
){
    fun convertToEntity(testPreviewId: Long): HumanPointsEntity {
        return HumanPointsEntity(
            testPreviewId = testPreviewId,
            testId = this.testId,
            type = this.type.name,
            selectedPoints = this.selectedPoints,
            score = score,
        )
    }
}

data class SliderAnswerRequest(
    val testId: Long,
    val questionId: Long,
    val sliderValue: Int,
    val score: Int
) {
    fun convertToEntity(testPreviewId: Long): SliderAnswerEntity {
        return SliderAnswerEntity(
            testPreviewId = testPreviewId,
            testId = this.testId,
            questionId = questionId,
            sliderValue = sliderValue,
            score = score,
        )
    }
}

data class GraphicAnswerRequest(
    val testId: Long,
    val selectedVariant: String = "",
    val score: Int
) {
    fun convertToEntity(testPreviewId: Long): GraphicAnswerEntity {
        return GraphicAnswerEntity(
            testPreviewId = testPreviewId,
            testId = this.testId,
            selectedVariant = selectedVariant,
            score = score,
        )
    }
}

data class YesNoAnswerRequest(
    val testId: Long,
    val questionId: Long,
    val answer: Boolean,
    val score: Int
) {
    fun convertToEntity(testPreviewId: Long): YesNoAnswerEntity {
        return YesNoAnswerEntity(
            testPreviewId = testPreviewId,
            testId = this.testId,
            questionId = questionId,
            answer = answer,
            score = score,
        )
    }
}

data class DisplaySliderAnswerRequest(
    val testId: Long,
    val sliderValue: Int = 0,
    val score: Int
) {
    fun convertToEntity(testPreviewId: Long): DisplaySliderAnswerEntity {
        return DisplaySliderAnswerEntity(
            testPreviewId = testPreviewId,
            testId = this.testId,
            sliderValue = sliderValue,
            score = score,
        )
    }
}

data class CommentAnswerRequest(
    val testId: Long,
    val comment: String = ""
){
    fun convertToEntity(testPreviewId: Long): CommentAnswerEntity {
        return CommentAnswerEntity(
            testPreviewId = testPreviewId,
            testId = this.testId,
            comment = comment
        )
    }
}