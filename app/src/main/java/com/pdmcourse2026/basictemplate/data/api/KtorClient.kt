package com.pdmcourse2026.basictemplate.data.api

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object KtorClient {
  private const val BASE_URL = "https://qjcxdvfzyseuvezacxsd.supabase.co/functions/v1/rankeuca/"
  private const val API_KEY = "a2575846-e593-459c-b263-a06318840538"

  val httpClient = HttpClient {
    install(ContentNegotiation) {
      json(Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        isLenient = true
      })
    }
    defaultRequest {
      url(BASE_URL)
      header(HttpHeaders.Authorization, "Bearer $API_KEY")
      header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
  }
}