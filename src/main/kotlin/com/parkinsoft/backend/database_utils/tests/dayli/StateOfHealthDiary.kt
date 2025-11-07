package com.parkinsoft.backend.database_utils.tests.dayli

import com.parkinsoft.backend.models.model.TestAnswerModel
import com.parkinsoft.backend.models.model.ShortTestPreviewModel
import com.parkinsoft.backend.models.model.TestQuestionModel
import com.parkinsoft.backend.models.model.TestType

private val TEST_NAME = "Дневник общего самочувствия "

val STATE_OF_HEALTH_DIARY = ShortTestPreviewModel(
    testType = TestType.STATE_OF_HEALTH_DIARY,
    testName = TEST_NAME,
    testTime = 15,
    questionsCount = 15,
    testQuestions = listOf(
        TestQuestionModel(
            questionId = 1,
            testQuestion = "Как вы оцениваете свое самочувствие сегодня?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Отличное",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Хорошее",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Удовлетворительное",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Плохое",
                    answerPoint = 1
                ),
            )
        ),
        TestQuestionModel(
            questionId = 2,
            testQuestion = "Насколько хорошо вы спали этой ночью?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Очень хорошо",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Хорошо",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Плохо",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Очень плохо",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 3,
            testQuestion = "Какой у вас сейчас уровень энергии?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Высокий",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Средний",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Низкий",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Очень низкий",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 4,
            testQuestion = "Как вы оцениваете свое настроение сегодня?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Отличное",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Хорошее",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Нейтральное",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Плохое",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 5,
            testQuestion = "Были ли у вас сегодня головные боли или головокружение?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Нет",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Легкие",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Умеренные",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Сильные",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 6,
            testQuestion = "Как вы оцениваете свой аппетит?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Очень хороший",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Нормальный",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Пониженный",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Отсутствует",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 7,
            testQuestion = "Были ли у вас сегодня тошнота или проблемы с пищеварением?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Нет",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Легкие",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Умеренные",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Сильные",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 8,
            testQuestion = "Как вы оцениваете уровень стресса сегодня?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 8,
                    testAnswer = "Низкий",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 8,
                    testAnswer = "Средний",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 8,
                    testAnswer = "Высокий",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 8,
                    testAnswer = "Очень высокий",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 9,
            testQuestion = "Испытывали ли вы сегодня усталость?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 9,
                    testAnswer = "Нет",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 9,
                    testAnswer = "Легкую",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 9,
                    testAnswer = "Умеренную",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 9,
                    testAnswer = "Сильную",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 10,
            testQuestion = "Были ли у вас затруднения с концентрацией внимания?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 10,
                    testAnswer = "Нет",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 10,
                    testAnswer = "Иногда",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 10,
                    testAnswer = "Часто",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 10,
                    testAnswer = "Постоянно",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 11,
            testQuestion = "Как вы оцениваете свое дыхание?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 11,
                    testAnswer = "Нормальное",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 11,
                    testAnswer = "Немного затруднено",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 11,
                    testAnswer = "Заметно затруднено",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 11,
                    testAnswer = "Очень тяжелое",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 12,
            testQuestion = "Были ли у вас сегодня боли в теле или мышечные спазмы?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 12,
                    testAnswer = "Нет",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 12,
                    testAnswer = "Легкие",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 12,
                    testAnswer = "Умеренные",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 12,
                    testAnswer = "Сильные",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 13,
            testQuestion = "Как вы оцениваете уровень физической активности сегодня?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 13,
                    testAnswer = "Высокий",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 13,
                    testAnswer = "Средний",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 13,
                    testAnswer = "Низкий",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 13,
                    testAnswer = "Отсутствует",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 14,
            testQuestion = "Насколько вы ощущаете эмоциональную стабильность сегодня?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 14,
                    testAnswer = "Очень стабильное состояние",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 14,
                    testAnswer = "Немного нестабильное",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 14,
                    testAnswer = "Нестабильное",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 14,
                    testAnswer = "Очень нестабильное",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 15,
            testQuestion = "Как вы оцениваете общее состояние вашего организма на данный момент?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 15,
                    testAnswer = "Отличное",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 15,
                    testAnswer = "Хорошее",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 15,
                    testAnswer = "Удовлетворительное",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 15,
                    testAnswer = "Плохое",
                    answerPoint = 1
                ),
            ),
        ),
    )
)