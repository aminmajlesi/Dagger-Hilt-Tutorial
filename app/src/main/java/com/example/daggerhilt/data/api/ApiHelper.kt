package com.example.daggerhilt.data.api

import com.example.daggerhilt.data.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}