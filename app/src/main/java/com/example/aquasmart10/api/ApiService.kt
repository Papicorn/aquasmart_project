package com.example.aquasmart10.api

import com.example.aquasmart10.model.LoginRequest
import com.example.aquasmart10.model.LoginResponse
import com.example.aquasmart10.model.modelKolam
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface YourApiService {
    @GET("kolam")
    suspend fun getKolam(): List<modelKolam>

    @POST("students")
    suspend fun addStudent(@Body student: modelKolam): Response<modelKolam>

    @POST("users/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}