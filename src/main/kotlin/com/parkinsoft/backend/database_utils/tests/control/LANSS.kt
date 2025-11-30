package com.parkinsoft.backend.database_utils.tests.control

import com.parkinsoft.backend.models.model.ShortTestPreviewModel
import com.parkinsoft.backend.models.model.TestAnswerModel
import com.parkinsoft.backend.models.model.TestQuestionModel
import com.parkinsoft.backend.models.model.TestType

private const val TEST_NAME = "LANSS"

val LANSS = ShortTestPreviewModel(
    testType = TestType.LANSS,
    testName = TEST_NAME,
    testTime = 10,
    questionsCount = 10,
    testQuestions = listOf(
        TestQuestionModel(
            questionId = 1,
            testQuestion = "Проявляется ли ваша боль в виде странных неприятных ощущений на коже? Можно ли сравнить эти ощущения с покалыванием?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "НЕТ – Боль, которую я испытываю, нельзя описать таким образом",
                    answerPoint = 0
                ),
                TestAnswerModel(
                    questionId = 1,
                    testAnswer = "ДА – Меня довольно часто беспокоят подобные ощущения",
                    answerPoint = 5
                ),
            )
        ),
        TestQuestionModel(
            questionId = 2,
            testQuestion = "Изменяется ли кожа в области локализации боли? Покрывается ли она пятнами? Выглядит ли покрасневшей?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "НЕТ – Боль не влияет на внешний вид кожи",
                    answerPoint = 0
                ),
                TestAnswerModel(
                    questionId = 2,
                    testAnswer = "ДА – Там, где меня беспокоит боль, внешний вид кожи отличается от нормального",
                    answerPoint = 5
                ),
            )
        ),
        TestQuestionModel(
            questionId = 3,
            testQuestion = "Повышена ли чувствительность к прикосновению на поражённом участке кожи? Можно ли сказать, что лёгкое поглаживание кожи, соприкосновение с одеждой вызывают неприятные или болевые ощущения?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "НЕТ – На поражённом участке кожи чувствительность не изменена",
                    answerPoint = 0
                ),
                TestAnswerModel(
                    questionId = 3,
                    testAnswer = "ДА – На поражённом участке чувствительность кожи повышена",
                    answerPoint = 3
                ),
            )
        ),
        TestQuestionModel(
            questionId = 4,
            testQuestion = "Появляется ли боль внезапно, в покое без видимых причин? Можно ли описать ее как пульсирующую, разрывную или похожую на удар электрическим током?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "НЕТ – Мои ощущения нельзя описать подобным образом",
                    answerPoint = 0
                ),
                TestAnswerModel(
                    questionId = 4,
                    testAnswer = "ДА – Меня довольно часто беспокоят подобные ощущения",
                    answerPoint = 2
                ),
            )
        ),
        TestQuestionModel(
            questionId = 5,
            testQuestion = "Отличается ли температура кожи на поражённом участке от температуры остальной поверхности кожи? Можно ли описать подобные ощущения как жжение или жар?",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "НЕТ – Меня не беспокоят подобные ощущения",
                    answerPoint = 0
                ),
                TestAnswerModel(
                    questionId = 5,
                    testAnswer = "ДА – Меня довольно часто беспокоят подобные ощущения",
                    answerPoint = 1
                ),
            )
        ),
        TestQuestionModel(
            questionId = 6,
            testQuestion = "Следующая часть теста предназначена для врача, передайте пожалуйста ему телефон.",
            testAnswers = listOf()
        ),
        TestQuestionModel(
            questionId = 7,
            testQuestion = "Оцените чувствительность к лёгкому прикосновению ватой на поражённом и здоровом участках кожи. Наличие аллодинии можно констатировать, если прикосновение к поражённому участку кожи вызывает боль или другие неприятные ощущения (покалывание, тошноту), в то время как при проведении теста на здоровом участке кожи подобных ощущений не возникает.",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "НЕТ – Чувствительность одинакова на обоих участках",
                    answerPoint = 0
                ),
                TestAnswerModel(
                    questionId = 6,
                    testAnswer = "ДА – Аллодиния только на поражённом участке",
                    answerPoint = 5
                ),
            )
        ),
        TestQuestionModel(
            questionId = 8,
            testQuestion = "Изменение порога болевой чувствительности. Определите порог болевой чувствительности на здоровом и поражённом участках кожи, используя иглу 23 калибра, вставленную внутрь цилиндра шприца объемом 2 мл. Если при уколе на здоровом участке ощущается острое прикосновение, а на поражённом участке иное – например, прикосновение не чувствуется совсем, ощущается тупое прикосновение (повышенный порог болевой чувствительности) или очень болезненное (сниженный порог болевой чувствительности), то можно констатировать изменение порога болевой чувствительности. Если укол не ощущается нигде, то наденьте иглу на шприц для увеличения веса и проведите тест повторно.",
            testAnswers = listOf(
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "НЕТ – Ощущения от укола иглой одинаковы на обоих участках",
                    answerPoint = 0
                ),
                TestAnswerModel(
                    questionId = 7,
                    testAnswer = "ДА – Изменённое ощущение от укола иглой в поражённой области",
                    answerPoint = 3
                ),
            )
        ),
    )
)