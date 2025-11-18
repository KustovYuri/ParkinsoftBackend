package com.parkinsoft.backend.database_utils.tests.control

import com.parkinsoft.backend.models.model.ShortTestPreviewModel
import com.parkinsoft.backend.models.model.TestAnswerModel
import com.parkinsoft.backend.models.model.TestQuestionModel
import com.parkinsoft.backend.models.model.TestType

private const val TEST_NAME = "HADS2"

val HADS2 = ShortTestPreviewModel(
    testType = TestType.HADS2,
    testName = TEST_NAME,
    testTime = 10,
    questionsCount = 7,
    testQuestions = listOf(
        TestQuestionModel(
            questionId = 1,
            testQuestion = "То, что приносило мне большое удовольствие, и сейчас вызывает у меня такое же чувство",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Определенно, это так",
                    answerPoint = 0
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Наверное, это так",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Лишь в очень малой степени, это так",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "Это совсем не так",
                    answerPoint = 3
                ),
            )
        ),
        TestQuestionModel(
            questionId = 2,
            testQuestion = "Я способен рассмеяться и увидеть в том или ином событии смешное",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Определенно, это так",
                    answerPoint = 0
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Наверное, это так",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Лишь в очень малой степени, это так",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "Совсем не способен",
                    answerPoint = 3
                ),
            )
        ),
        TestQuestionModel(
            questionId = 3,
            testQuestion = "Я испытываю бодрость",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Совсем не испытываю",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Очень редко",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Иногда",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "Практически все время",
                    answerPoint = 0
                ),
            )
        ),
        TestQuestionModel(
            questionId = 4,
            testQuestion = "Мне кажется, что я стал все делать очень медленно",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Практически все время",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Часто",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Иногда",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "Совсем нет",
                    answerPoint = 0
                ),
            )
        ),
        TestQuestionModel(
            questionId = 5,
            testQuestion = "Я не слежу за своей внешностью",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Определенно, это так",
                    answerPoint = 3
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Я не уделяю этому столько времени, сколько нужно",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Может быть, я стал меньше уделять этому времени",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "Я слежу за собой так же, как и раньше",
                    answerPoint = 0
                ),
            )
        ),
        TestQuestionModel(
            questionId = 6,
            testQuestion = "Я считаю, что мои дела (занятия, увлечения) могут принести мне чувство удовлетворения",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Точно так же, как и обычно",
                    answerPoint = 0
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Да, но не в той степени, как раньше",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Значительно меньше, чем обычно",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "Совсем так не считаю",
                    answerPoint = 3
                ),
            )
        ),
        TestQuestionModel(
            questionId = 7,
            testQuestion = "Я могу получить удовольствие от хорошей книги, радио- или телепрограммы",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Часто",
                    answerPoint = 0
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Иногда",
                    answerPoint = 1
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Редко",
                    answerPoint = 2
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "Очень редко",
                    answerPoint = 3
                ),
            )
        ),
    )
)