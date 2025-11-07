package com.parkinsoft.backend.controller

import com.parkinsoft.backend.models.entity.Patient
import com.parkinsoft.backend.models.model.LoginModel
import com.parkinsoft.backend.service.LoginService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController(
    private val loginService: LoginService
) {
    @GetMapping("/{phoneNumber}")
    fun getUserRole(@PathVariable phoneNumber: String): LoginModel  = loginService.loginUser(phoneNumber)
}