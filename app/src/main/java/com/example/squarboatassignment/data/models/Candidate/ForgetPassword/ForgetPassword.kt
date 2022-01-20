package com.example.squarboatassignment.data.models.Candidate.ForgetPassword


import com.google.gson.annotations.SerializedName

data class ForgetPassword(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean
)