package com.parkinsoft.backend.models.model

data class LoginModel(
    val userId: Long,
    val role: Role
)

enum class Role {
    PATIENT,
    DOCTOR,
    UNKNOWN
}
