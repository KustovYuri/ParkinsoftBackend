package com.parkinsoft.backend.controller

import com.parkinsoft.backend.models.entity.Doctor
import com.parkinsoft.backend.models.model.DischargeModel
import com.parkinsoft.backend.models.model.DoctorWithPatientsModel
import com.parkinsoft.backend.models.model.LargePatientModel
import com.parkinsoft.backend.models.model.PatientBody
import com.parkinsoft.backend.service.DoctorService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/doctor")
class DoctorController(private val service: DoctorService) {
    @GetMapping
    fun getAll(): List<Doctor> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): DoctorWithPatientsModel? = service.getDoctorWithPatients(id)

    @GetMapping("patientInfo/{patientId}")
    fun getPatientInfo(@PathVariable patientId: Long): LargePatientModel = service.getLargePatientInfo(patientId)

    @PostMapping("createFinishTests/{patientId}")
    fun createFinishTests(@PathVariable patientId: Long) = service.createFinishTests(patientId)

    @PostMapping("dischargePatient/{patientId}")
    fun dischargePatient(@PathVariable patientId: Long) = service.dischargePatient(patientId)

    @PostMapping
    fun create(@RequestBody user: Doctor): Doctor = service.create(user)

    @PostMapping("/updateDateDischarge")
    fun updateDateDischarge(@RequestBody dischargeModel: DischargeModel) = service.discharge(dischargeModel)

    @PostMapping("/createNewPatient")
    fun createNewPatient(@RequestBody user: PatientBody): Long = service.createNewPatient(user)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
