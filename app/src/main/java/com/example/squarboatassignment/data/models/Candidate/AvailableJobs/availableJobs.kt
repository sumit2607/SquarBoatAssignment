package com.example.squarboatassignment.data.models.Candidate.AvailableJobs


import com.google.gson.annotations.SerializedName

data class availableJobs(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("success")
    val success: Boolean
)