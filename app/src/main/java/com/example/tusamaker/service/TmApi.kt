package com.example.tusamaker.service

import com.example.tusamaker.data.Category
import com.example.tusamaker.data.EventModel
import com.example.tusamaker.data.EventModelResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TmApi {
    @GET("events/")
    fun getAllEventsAsync(): Deferred<Response<EventModelResponse>>

    @GET("events/{id}/")
    fun getEventByIdAsync(@Path("id") id: Int): Deferred<Response<EventModel>>

    @GET("categories/")
    fun getAllCategoriesAsync(): Deferred<Response<Category>>
}

