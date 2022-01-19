package com.example.squarboatassignment.data.models.endurl.reg.regResponse

data class registerResponse(
    val confirmPassword: String,
    val email: String,
    val name: String,
    val password: String,
    val skills: String,
    val userRole: Int
)