package com.pdmcourse2026.basictemplate.data.model

import kotlinx.serialization.Serializable

@Serializable
data class VoteRequest(
    val optionId: Int
)