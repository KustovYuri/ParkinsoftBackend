package com.parkinsoft.backend.repository

import com.parkinsoft.backend.models.entity.Doctor
import com.parkinsoft.backend.models.entity.Patient
import com.parkinsoft.backend.models.entity.TestPreview
import com.parkinsoft.backend.models.entity.TestSingleAnswer
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PatientRepository : JpaRepository<Patient, Long> {
    fun findAllByDoctorId(doctorId: Long): List<Patient>

    fun findFirstByPhoneNumber(phoneNumber: String): Patient?

    @Modifying
    @Transactional
    @Query("UPDATE Patient p SET p.lastDateAllTestsRequest = :date WHERE p.id = :id")
    fun updateLastRequestDate(@Param("id") id: Long, @Param("date") date: String): Int
}

interface TestPreviewRepository : JpaRepository<TestPreview, Long> {
    fun findAllByPatientId(patientId: Long): List<TestPreview>

    @Query(
        """
            SELECT tp 
            FROM TestPreview tp 
            WHERE tp.patientId = :patientId
            AND tp.isCompleted = true
        """
    )
    fun findAllCompletedTestPreview(patientId: Long): List<TestPreview>

    @Modifying
    @Transactional
    @Query("UPDATE TestPreview t SET t.isCompleted = true WHERE t.id = :id")
    fun markCompletedTestPreviewById(@Param("id") id: Long): Int

    @Modifying
    @Transactional
    @Query("UPDATE TestPreview t SET t.isViewed = false WHERE t.id = :id")
    fun markUnviewedTestPreviewById(@Param("id") id: Long): Int

    @Modifying
    @Transactional
    @Query("UPDATE TestPreview t SET t.isViewed = true WHERE t.id = :id")
    fun markViewedTestPreviewById(@Param("id") id: Long): Int

    @Query("""
        SELECT COUNT(tp)
        FROM TestPreview tp
        WHERE tp.patientId = :patientId AND tp.isViewed = false
    """)
    fun countUnviewedByPatientId(@Param("patientId") patientId: Long): Long

    @Modifying
    @Transactional
    @Query("UPDATE TestPreview t SET t.testCompletedDate = :date WHERE t.id = :id")
    fun updateCompletedDate(@Param("id") id: Long, @Param("date") date: String): Int

    @Modifying
    @Transactional
    @Query("UPDATE TestPreview t SET t.maxSore = :maxSore WHERE t.id = :id")
    fun updateMaxScore(@Param("id") id: Long, @Param("maxSore") maxSore: Int): Int

    @Modifying
    @Transactional
    @Query("UPDATE TestPreview t SET t.score = :score WHERE t.id = :id")
    fun updateScore(@Param("id") id: Long, @Param("score") score: Int): Int
}

interface TestAnswerRepository : JpaRepository<TestSingleAnswer, Long> {
    fun findByTestPreviewId(testPreviewId: Long): List<TestSingleAnswer>

    @Modifying
    @Transactional
    @Query("DELETE FROM TestSingleAnswer ta WHERE ta.testPreviewId = :previewId")
    fun deleteAllByTestPreviewId(@Param("previewId") previewId: Long)

    @Query("""
        SELECT COALESCE(SUM(ta.answerPoint), 0)
        FROM TestSingleAnswer ta
        WHERE ta.testPreviewId = :previewId
    """)
    fun countSummaryPointsInTest(previewId: Long): Long
}

interface DoctorRepository : JpaRepository<Doctor, Long> {
    fun findFirstByPhoneNumber(phoneNumber: String): Doctor?
}