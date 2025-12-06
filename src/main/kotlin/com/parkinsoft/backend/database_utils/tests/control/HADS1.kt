package com.parkinsoft.backend.database_utils.tests.control

import com.parkinsoft.backend.models.model.ShortTestPreviewModel
import com.parkinsoft.backend.models.model.TestAnswerModel
import com.parkinsoft.backend.models.model.TestQuestionModel
import com.parkinsoft.backend.models.model.TestType

private const val TEST_NAME = "HADS1"

val HADS1 = ShortTestPreviewModel(
    testType = TestType.HADS1,
    testName = TEST_NAME,
    testTime = 10,
    questionsCount = 7,
    testQuestions = listOf(
        TestQuestionModel(
            questionId = 1,
            testQuestion = "Я испытываю напряжение, мне не по себе",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Все время",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Часто",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Время от времени, иногда",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Совсем не испытываю",
                    answerPoint = 0
                ),
            )
        ),
        TestQuestionModel(
            questionId = 2,
            testQuestion = "Я испытываю страх, кажется, что что-то ужасное может вот-вот случиться",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Определенно это так, и страх очень велик",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Да, это так, но страх не очень велик",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Иногда, но это меня не беспокоит",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Совсем не испытываю",
                    answerPoint = 0
                ),
            )
        ),
        TestQuestionModel(
            questionId = 3,
            testQuestion = "Беспокойные мысли крутятся у меня в голове",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Постоянно",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Большую часть времени",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Время от времени и не так часто",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Только иногда",
                    answerPoint = 0
                ),
            )
        ),
        TestQuestionModel(
            questionId = 4,
            testQuestion = "Я легко могу присесть и расслабиться",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Определенно, это так",
                    answerPoint = 0
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Наверно, это так",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Лишь изредка, это так",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Совсем не могу",
                    answerPoint = 3
                ),
            )
        ),
        TestQuestionModel(
            questionId = 5,
            testQuestion = "Я испытываю внутреннее напряжение или дрожь",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Совсем не испытываю",
                    answerPoint = 0
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Иногда",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Часто",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Очень часто",
                    answerPoint = 3
                ),
            )
        ),
        TestQuestionModel(
            questionId = 6,
            testQuestion = "Я испытываю неусидчивость, мне постоянно нужно двигаться",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Определенно, это так",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Наверно, это так",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Лишь в некоторой степени, это так",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Совсем не испытываю",
                    answerPoint = 0
                ),
            )
        ),
        TestQuestionModel(
            questionId = 7,
            testQuestion = "У меня бывает внезапное чувство паники",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Очень часто",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Довольно часто",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Не так уж часто",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Совсем не бывает",
                    answerPoint = 0
                ),
            )
        ),
    )
)