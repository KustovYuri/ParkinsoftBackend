package com.parkinsoft.backend.database_utils

import com.parkinsoft.backend.database_utils.tests.dayli.STATE_OF_HEALTH_DIARY
import com.parkinsoft.backend.database_utils.tests.dayli.TEST_STIMULATION_DIARY
import com.parkinsoft.backend.models.entity.Doctor
import com.parkinsoft.backend.models.entity.Patient
import com.parkinsoft.backend.models.mappers.convertToTestPreviewEntity
import com.parkinsoft.backend.models.model.TestType
import com.parkinsoft.backend.repository.DoctorRepository
import com.parkinsoft.backend.repository.PatientRepository
import com.parkinsoft.backend.repository.TestAnswerRepository
import com.parkinsoft.backend.repository.TestPreviewRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class DataInitializer(
    private val patientRepository: PatientRepository,
    private val testPreviewRepository: TestPreviewRepository,
    private val doctorRepository: DoctorRepository
): CommandLineRunner {
    override fun run(vararg args: String?) {
// Стартовая инициализация данных (пациенты, доктора и тесты)
//        doctorsInit()
//        patientsInit()
//        testPreviewInit()
    }

    private fun patientsInit() {
        val allDoctors = doctorRepository.findAll()
        val patients = listOf(
            listOf(
                Patient(
                    doctorId = 1,
                    name = "Юрий",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887355",
                    birthDate = "15.03.2000",
                    diagnosis = "Циклотимия",
                    dateReceipt = "15.03.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 1,
                    name = "Владимир",
                    secondName = "Володин",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.2000",
                    diagnosis = "Альцгеймер",
                    dateReceipt = "12.02.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 1,
                    name = "Анатолий",
                    secondName = "Попанов",
                    middleName = "Анатольевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.2000",
                    diagnosis = "Мигрень",
                    dateReceipt = "12.02.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = false,
                    sex = true
                ),
                Patient(
                    doctorId = 1,
                    name = "Сабина",
                    secondName = "Кустова",
                    middleName = "Батуровна",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1990",
                    diagnosis = "Невроз",
                    dateReceipt = "12.02.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = false,
                    sex = false
                ),
                Patient(
                    doctorId = 1,
                    name = "Сергей",
                    secondName = "Иванов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1990",
                    diagnosis = "Цитоплазмия",
                    dateReceipt = "12.02.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 1,
                    name = "Иван",
                    secondName = "Попов",
                    middleName = "Юрьевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1990",
                    diagnosis = "Диабет",
                    dateReceipt = "12.02.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 1,
                    name = "Дмитрий",
                    secondName = "Семенов",
                    middleName = "Анатольевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1990",
                    diagnosis = "Аллергия",
                    dateReceipt = "12.02.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 1,
                    name = "Евгений",
                    secondName = "Антонов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1990",
                    diagnosis = "Циклотимия",
                    dateReceipt = "12.02.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 1,
                    name = "Лидия",
                    secondName = "Говорюк",
                    middleName = "Дмитриевна",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1990",
                    diagnosis = "Депрессия",
                    dateReceipt = "12.02.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = false
                ),
                Patient(
                    doctorId = 1,
                    name = "Владимир",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1990",
                    diagnosis = "Альцгеймер",
                    dateReceipt = "12.02.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 1,
                    name = "Евгений",
                    secondName = "Батур",
                    middleName = "Исламович",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1990",
                    diagnosis = "Цитоплазмия",
                    dateReceipt = "12.02.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 1,
                    name = "Валерий",
                    secondName = "Иван",
                    middleName = "Иванович",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1990",
                    diagnosis = "Альцгеймер",
                    dateReceipt = "12.02.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 1,
                    name = "Владимир",
                    secondName = "Должин",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1990",
                    diagnosis = "Паркинсон",
                    dateReceipt = "12.02.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = false,
                    sex = true
                ),
                Patient(
                    doctorId = 1,
                    name = "Сергей",
                    secondName = "Иванов",
                    middleName = "Дмитриевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1990",
                    diagnosis = "Паркинсон",
                    dateReceipt = "12.02.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = false,
                    sex = true
                ),
            ),
            listOf(
                Patient(
                    doctorId = 2,
                    name = "Сергей",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1990",
                    diagnosis = "Циклотимия",
                    dateReceipt = "12.05.2024",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 2,
                    name = "Юрий",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1990",
                    diagnosis = "Циклотимия",
                    dateReceipt = "13.05.2024",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 2,
                    name = "Юрий",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1990",
                    diagnosis = "Циклотимия",
                    dateReceipt = "15.03.2024",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 2,
                    name = "Юрий",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1980",
                    diagnosis = "Циклотимия",
                    dateReceipt = "15.03.2024",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 2,
                    name = "Наталья",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1980",
                    diagnosis = "Циклотимия",
                    dateReceipt = "15.03.2024",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = false
                ),
                Patient(
                    doctorId = 2,
                    name = "Юрий",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1980",
                    diagnosis = "Циклотимия",
                    dateReceipt = "11.07.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 2,
                    name = "Юрий",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1980",
                    diagnosis = "Циклотимия",
                    dateReceipt = "11.07.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
            ),
            listOf(
                Patient(
                    doctorId = 3,
                    name = "Юрий",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1980",
                    diagnosis = "Циклотимия",
                    dateReceipt = "11.07.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = false,
                    sex = true
                ),
                Patient(
                    doctorId = 3,
                    name = "Владимир",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1980",
                    diagnosis = "Циклотимия",
                    dateReceipt = "11.07.2025",
                    stateHealth = "Идет на поправку",
                    onTreatments = false,
                    sex = true
                ),
                Patient(
                    doctorId = 3,
                    name = "Владимир",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1980",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.07.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 3,
                    name = "Владимир",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1970",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.03.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 3,
                    name = "Владимир",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1970",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.03.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 3,
                    name = "Юрий",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1970",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.03.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = false,
                    sex = true
                ),
                Patient(
                    doctorId = 3,
                    name = "Наталья",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1970",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.03.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = false
                )
            ),
            listOf(
                Patient(
                    doctorId = 4,
                    name = "Юрий",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1970",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.03.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 4,
                    name = "Наталья",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1970",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.03.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = false
                ),
                Patient(
                    doctorId = 4,
                    name = "Сергей",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1970",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.03.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 4,
                    name = "Юрий",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1970",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.03.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 4,
                    name = "Юрий",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1970",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.03.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 4,
                    name = "Юрий",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1970",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.03.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 4,
                    name = "Владимир",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1970",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.03.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 4,
                    name = "Владимир",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1970",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.03.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 4,
                    name = "Юрий",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1970",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.03.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
                Patient(
                    doctorId = 4,
                    name = "Сергей",
                    secondName = "Кустов",
                    middleName = "Сергеевич",
                    phoneNumber = "89024887312",
                    birthDate = "15.03.1970",
                    diagnosis = "Циклотимия",
                    dateReceipt = "10.03.2023",
                    stateHealth = "Идет на поправку",
                    onTreatments = true,
                    sex = true
                ),
            )
        )
        val patientsWithDoctor = mutableListOf<Patient>()

        allDoctors.forEachIndexed { idx, doctor ->
            if (idx < patients.size) {
                patients[idx].forEach {
                    patientsWithDoctor.add(
                        it.copy(doctorId = doctor.id ?: -1)
                    )
                }
            }
        }

        patientRepository.saveAll(patientsWithDoctor)
    }

    private fun testPreviewInit() {
        val allPatients = patientRepository.findAll()
        allPatients.forEach { patient ->
            val allTestsPreview = listOf(
                TEST_STIMULATION_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now(),
                ),
                STATE_OF_HEALTH_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now(),
                ),
                TEST_STIMULATION_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(1),
                ),
                STATE_OF_HEALTH_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(1),
                ),
                TEST_STIMULATION_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(2),
                ),
                STATE_OF_HEALTH_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(2),
                ),
                TEST_STIMULATION_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(3),
                ),
                STATE_OF_HEALTH_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(3),
                ),
                TEST_STIMULATION_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(4),
                ),
                STATE_OF_HEALTH_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(4),
                ),
                TEST_STIMULATION_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(5),
                ),
                STATE_OF_HEALTH_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(5),
                ),
                TEST_STIMULATION_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(6),
                ),
                STATE_OF_HEALTH_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(6),
                ),
                TEST_STIMULATION_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(7),
                ),
                STATE_OF_HEALTH_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(7),
                ),
                TEST_STIMULATION_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(8),
                ),
                STATE_OF_HEALTH_DIARY.convertToTestPreviewEntity(
                    patientId = patient.id ?: 0,
                    testDate = LocalDate.now().minusDays(8),
                ),
            )
            testPreviewRepository.saveAll(allTestsPreview)
        }
    }

    private fun doctorsInit() {
        val doctors = listOf(
            Doctor(firstName = "Дмитрий", lastName = "Кулибин", middleName = "Михайлович", phoneNumber = "89024887366"),
            Doctor(firstName = "Петр", lastName = "Жмышенко", middleName = "Дмитреевич", phoneNumber = "89024887322"),
            Doctor(firstName = "Владимир", lastName = "Семенов", middleName = "Семнович", phoneNumber = "89024887311"),
            Doctor(firstName = "Антон", lastName = "Клубин", middleName = "Сергеевич", phoneNumber = "89024887300"),
        )

        doctorRepository.saveAll(doctors)
    }

}