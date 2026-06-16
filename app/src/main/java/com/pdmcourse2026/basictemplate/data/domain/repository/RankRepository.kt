package com.pdmcourse2026.basictemplate.data.domain.repository

import com.pdmcourse2026.basictemplate.data.model.Place

interface RankRepository {
    suspend fun getPlaces(): Result<List<Place>>
    suspend fun castVote(placeId: Int): Result<Boolean>
}