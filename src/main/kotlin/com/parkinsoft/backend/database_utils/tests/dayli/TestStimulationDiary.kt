package com.parkinsoft.backend.database_utils.tests.dayli

import com.parkinsoft.backend.models.model.TestAnswerModel
import com.parkinsoft.backend.models.model.ShortTestPreviewModel
import com.parkinsoft.backend.models.model.TestQuestionModel
import com.parkinsoft.backend.models.model.TestType

private const val TEST_NAME = "Дневник тестовой стимуляции"

val TEST_STIMULATION_DIARY = ShortTestPreviewModel(
    testType = TestType.TEST_STIMULATION_DIARY,
    testName = TEST_NAME,
    testTime = 15,
    questionsCount = 15,
    testQuestions = listOf(
        TestQuestionModel(
            questionId = 1,
            testQuestion = "Каким определениям соответствует боль, которую вы испытываете?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Ощущение жжения",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Болезненное ощущение холода",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Ощущение как от удара током",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Не соответствует ни одному",
                    answerPoint = 4
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 2,
            testQuestion = "Насколько сильна боль, которую вы ощущаете сейчас?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Слабая",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Средняя",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Сильная",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Очень сильная",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 3,
            testQuestion = "Как долго продолжается боль?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Несколько секунд",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Минуты",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Часы",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Постоянно",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 4,
            testQuestion = "Насколько часто вы испытываете боль?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Редко",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Иногда",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Часто",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Постоянно",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 5,
            testQuestion = "Как боль влияет на ваш сон?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Не мешает сну",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Иногда мешает уснуть",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Часто прерывает сон",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Не дает спать совсем",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 6,
            testQuestion = "Как боль влияет на вашу способность выполнять повседневные задачи?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Не влияет",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Иногда мешает",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Сильно мешает",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Полностью ограничивает",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 7,
            testQuestion = "Как часто вы принимаете обезболивающие препараты?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Никогда",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Редко",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Регулярно",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Постоянно",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 8,
            testQuestion = "Что обычно помогает вам уменьшить боль?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 8,
                    testAnswer = "Отдых",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 8,
                    testAnswer = "Массаж",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 8,
                    testAnswer = "Лекарства",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 8,
                    testAnswer = "Ничего не помогает",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 9,
            testQuestion = "В какое время суток боль ощущается сильнее всего?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 9,
                    testAnswer = "Утром",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 9,
                    testAnswer = "Днем",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 9,
                    testAnswer = "Вечером",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 9,
                    testAnswer = "Ночью",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 10,
            testQuestion = "Как бы вы описали характер вашей боли?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 10,
                    testAnswer = "Тупая",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 10,
                    testAnswer = "Острая",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 10,
                    testAnswer = "Колющая",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 10,
                    testAnswer = "Пульсирующая",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 11,
            testQuestion = "Изменяется ли боль при движении?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 11,
                    testAnswer = "Становится сильнее",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 11,
                    testAnswer = "Становится слабее",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 11,
                    testAnswer = "Не изменяется",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 11,
                    testAnswer = "Затрудняюсь ответить",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 12,
            testQuestion = "Возникает ли боль в покое?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 12,
                    testAnswer = "Никогда",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 12,
                    testAnswer = "Иногда",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 12,
                    testAnswer = "Часто",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 12,
                    testAnswer = "Всегда",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 13,
            testQuestion = "Насколько боль влияет на ваше настроение?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 13,
                    testAnswer = "Не влияет",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 13,
                    testAnswer = "Иногда вызывает раздражение",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 13,
                    testAnswer = "Часто снижает настроение",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 13,
                    testAnswer = "Вызывает депрессию",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 14,
            testQuestion = "Сколько по времени вы можете оставаться активным до появления боли?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 14,
                    testAnswer = "Менее 10 минут",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 14,
                    testAnswer = "10–30 минут",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 14,
                    testAnswer = "30–60 минут",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 14,
                    testAnswer = "Более часа",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 15,
            testQuestion = "Как вы оцениваете общее влияние боли на качество вашей жизни?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 15,
                    testAnswer = "Минимальное",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 15,
                    testAnswer = "Умеренное",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 15,
                    testAnswer = "Серьезное",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 15,
                    testAnswer = "Критическое",
                    answerPoint = 1
                ),
            ),
        ),
    )
)