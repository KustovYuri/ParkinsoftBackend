package com.parkinsoft.backend.models.entity

import com.parkinsoft.backend.models.model.CommentAnswerRequest
import com.parkinsoft.backend.models.model.DisplaySliderAnswerRequest
import com.parkinsoft.backend.models.model.GraphicAnswerRequest
import com.parkinsoft.backend.models.model.HumanImageType
import com.parkinsoft.backend.models.model.HumanPointsRequest
import com.parkinsoft.backend.models.model.SingleAnswerRequest
import com.parkinsoft.backend.models.model.SliderAnswerRequest
import com.parkinsoft.backend.models.model.YesNoAnswerRequest
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class SingleAnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val testId: Long,
    val selectedAnswer: String,
    val score: Int
){
    fun convertToRequest(): SingleAnswerRequest {
        return SingleAnswerRequest(
            testId = this.testId,
            selectedAnswer = selectedAnswer,
            score = score,
        )
    }
}

@Entity
data class HumanPointsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val testId: Long,
    val type: String,
    @Column(columnDefinition = "integer[]")
    val selectedPoints: List<Int>,
    val score: Int
){
    fun convertToRequest(): HumanPointsRequest {
        return HumanPointsRequest(
            testId = this.testId,
            type = HumanImageType.valueOf(this.type),
            selectedPoints = this.selectedPoints,
            score = score,
        )
    }
}

@Entity
data class SliderAnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val testId: Long,
    val questionId: Long,
    val sliderValue: Int,
    val score: Int
){
    fun convertToRequest(): SliderAnswerRequest {
        return SliderAnswerRequest(
            testId = this.testId,
            questionId = questionId,
            sliderValue = sliderValue,
            score = score,
        )
    }
}

@Entity
data class GraphicAnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val testId: Long,
    val selectedVariant: String = "",
    val score: Int
) {
    fun convertToRequest(): GraphicAnswerRequest {
        return GraphicAnswerRequest(
            testId = this.testId,
            selectedVariant = selectedVariant,
            score = score,
        )
    }
}

@Entity
data class YesNoAnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val testId: Long,
    val questionId: Long,
    val answer: Boolean,
    val score: Int
) {
    fun convertToRequest(): YesNoAnswerRequest {
        return YesNoAnswerRequest(
            testId = this.testId,
            questionId = questionId,
            answer = answer,
            score = score,
        )
    }
}

@Entity
data class DisplaySliderAnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val testId: Long,
    val sliderValue: Int = 0,
    val score: Int
) {
    fun convertToRequest(): DisplaySliderAnswerRequest {
        return DisplaySliderAnswerRequest(
            testId = this.testId,
            sliderValue = sliderValue,
            score = score,
        )
    }
}

@Entity
data class CommentAnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val testPreviewId: Long,
    val testId: Long,
    val comment: String = ""
){
    fun convertToRequest(): CommentAnswerRequest {
        return CommentAnswerRequest(
            testId = this.testId,
            comment = comment
        )
    }
}