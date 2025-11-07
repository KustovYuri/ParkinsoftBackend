package com.parkinsoft.backend.controller

import com.parkinsoft.backend.models.entity.Patient
import com.parkinsoft.backend.models.model.ShortPatientModel
import com.parkinsoft.backend.service.PatientService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/patient")
class PatientController(private val service: PatientService) {
    @GetMapping
    fun getAll(): List<Patient> = service.getAll()

    @GetMapping("/short/{id}")
    fun getById(@PathVariable id: Long): ShortPatientModel? = service.getShortPatientById(id)

    @PostMapping
    fun create(@RequestBody user: Patient): Patient = service.create(user)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}