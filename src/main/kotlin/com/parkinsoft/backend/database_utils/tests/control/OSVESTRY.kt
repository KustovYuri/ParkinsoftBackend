package com.parkinsoft.backend.database_utils.tests.control

import com.parkinsoft.backend.models.model.ShortTestPreviewModel
import com.parkinsoft.backend.models.model.TestAnswerModel
import com.parkinsoft.backend.models.model.TestQuestionModel
import com.parkinsoft.backend.models.model.TestType

private const val TEST_NAME = "Освестри"

val OSVESTRY = ShortTestPreviewModel(
    testType = TestType.OSVESTRY,
    testName = TEST_NAME,
    testTime = 10,
    questionsCount = 10,
    testQuestions = listOf(
        TestQuestionModel(
            questionId = 1,
            testQuestion = "Боль в настоящий момент:",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "В настоящий момент у меня нет боли.",
                    answerPoint = 6
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "В настоящий момент боль очень лёгкая.",
                    answerPoint = 5
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "В настоящий момент боль умеренная.",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "В настоящий момент боль довольно сильная.",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "В настоящий момент боль очень сильная.",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "В настоящий момент боль наихудшая из всех болей, которые только можно себе представить.",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 2,
            testQuestion = "Самообслуживание (умывание, одевание и т.д.):",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Я могу обслуживать себя нормально без особой боли.",
                    answerPoint = 6
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Я могу обслуживать себя нормально с некоторой болью.",
                    answerPoint = 5
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Самообслуживание причиняет мне боль; я медлителен и осторожен.",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Я нуждаюсь в некоторой помощи, но в основном справляюсь самостоятельно.",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Чтобы обслужить себя я нуждаюсь в ежедневной помощи.",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Я не могу одеться, с трудом умываюсь и остаюсь в постели.",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 3,
            testQuestion = "Поднимание предметов:",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Я могу поднимать тяжёлые предметы без особой боли.",
                    answerPoint = 6
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Я могу поднимать тяжёлые предметы с некоторой болью.",
                    answerPoint = 5
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Боль мешает мне поднимать тяжёлые предметы с пола, но я могу справиться, если они расположены удобно, например на столе.",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Боль мешает мне поднимать тяжёлые предметы с пола, но я могу справиться с лёгкими предметами или предметами средней тяжести, если они удобно расположены.",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Я могу поднимать только очень лёгкие предметы.",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Я вовсе не могу ни поднять, ни перенести что-либо.",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 4,
            testQuestion = "Ходьба:",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Боль не мешает мне ходить на любые расстояния.",
                    answerPoint = 6
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Боль мешает мне ходить на расстояние больше 1 км.",
                    answerPoint = 5
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Боль мешает мне ходить на расстояние больше 500 метров.",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Боль мешает мне ходить на расстояние больше чем 100 метров.",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Я могу ходить, только опираясь на трость, костыли или ходунки.",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Я с трудом добираюсь до туалета и большую часть времени остаюсь в постели.",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 5,
            testQuestion = "Сидение:",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Я могу сидеть на любом стуле столько, сколько захочу.",
                    answerPoint = 6
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Я могу сидеть столько, сколько захочу, только на моём любимом стуле.",
                    answerPoint = 5
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Боль мешает мне сидеть больше 1 часа.",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Боль мешает мне сидеть больше 30 минут.",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Боль мешает мне сидеть больше 10 минут.",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Из-за боли я вообще не могу сидеть.",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 6,
            testQuestion = "Стояние:",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Я могу стоять столько, сколько захочу, без особой боли.",
                    answerPoint = 6
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Я могу стоять столько, сколько захочу, с некоторой болью.",
                    answerPoint = 5
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Боль мешает мне стоять больше 1 часа.",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Боль мешает мне стоять больше 30 минут.",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Боль мешает мне стоять больше 10 минут.",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Из-за боли я вообще не могу стоять.",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 7,
            testQuestion = "Сон:",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Мой сон никогда не прерывается из-за боли.",
                    answerPoint = 6
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Иногда мой сон прерывается из-за боли.",
                    answerPoint = 5
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Из-за боли я сплю меньше 6 часов.",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Из-за боли я сплю меньше 4 часов.",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Из-за боли я сплю меньше 2 часов.",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Из-за боли я вообще не могу уснуть.",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 8,
            testQuestion = "Сексуальная жизнь:",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 8,
                    testAnswer = "Моя сексуальная жизнь нормальна и не причиняет особой боли.",
                    answerPoint = 6
                ),
                TestAnswerModel(
                    questionId = 8,
                    testAnswer = "Моя сексуальная жизнь нормальна, но причиняет небольшую боль.",
                    answerPoint = 5
                ),
                TestAnswerModel(
                    questionId = 8,
                    testAnswer = "Моя сексуальная жизнь почти нормальна, но очень болезненна.",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 8,
                    testAnswer = "Моя сексуальная жизнь сильно ограничена болью.",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 8,
                    testAnswer = "Из-за боли я почти лишен / лишена сексуальной жизни.",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 8,
                    testAnswer = "Боль лишает меня сексуальной жизни.",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 9,
            testQuestion = "Образ жизни:",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 9,
                    testAnswer = "Я веду активный образ жизни без особой боли.",
                    answerPoint = 6
                ),
                TestAnswerModel(
                    questionId = 9,
                    testAnswer = "Я веду активный образ жизни с некоторой болью.",
                    answerPoint = 5
                ),
                TestAnswerModel(
                    questionId = 9,
                    testAnswer = "Боль не особенно влияет на мой образ жизни, но ограничивает наиболее активную деятельность, например, занятия спортом и т.п.",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 9,
                    testAnswer = "Из-за боли моя активность ограничена; я выхожу из дома реже, чем обычно.",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 9,
                    testAnswer = "Из-за боли моя активность ограничена пределами дома.",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 9,
                    testAnswer = "Из-за боли моя активность полностью ограничена.",
                    answerPoint = 1
                ),
            ),
        ),
        TestQuestionModel(
            questionId = 10,
            testQuestion = "Поездки, путешествия:",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 10,
                    testAnswer = "Я могу поехать куда угодно без боли.",
                    answerPoint = 6
                ),
                TestAnswerModel(
                    questionId = 10,
                    testAnswer = "Я могу поехать куда угодно с некоторой болью.",
                    answerPoint = 5
                ),
                TestAnswerModel(
                    questionId = 10,
                    testAnswer = "Боль довольно сильная, но я могу выдержать двухчасовую поездку.",
                    answerPoint = 4
                ),
                TestAnswerModel(
                    questionId = 10,
                    testAnswer = "Из-за боли я могу выдержать поездку, длящуюся не больше 1 часа.",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 10,
                    testAnswer = "Из-за боли я могу выдержать поездку, длящуюся не больше 30 минут.",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 10,
                    testAnswer = "Я могу доехать только до врача или до больницы.",
                    answerPoint = 1
                ),
            ),
        ),
    )
)