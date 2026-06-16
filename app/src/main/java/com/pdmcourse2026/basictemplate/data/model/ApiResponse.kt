package com.pdmcourse2026.basictemplate.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val ok: Boolean,
    val message: String? = null,
    val apiKey: String? = null
)