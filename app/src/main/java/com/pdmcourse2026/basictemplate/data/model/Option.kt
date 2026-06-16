package com.pdmcourse2026.basictemplate.data.model

import com.pdmcourse2026.basictemplate.data.database.entities.OptionEntity
import kotlinx.serialization.Serializable

@Serializable
data class Option(
    val id: Int = 0,
    val name: String,
    val imageUrl: String,
    val questionId: Int = 0,
)

fun Option.toEntity(): OptionEntity {
    return OptionEntity(
        id = id,
        name = name,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}