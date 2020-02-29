package com.example.tusamaker.data

data class EventModel(
    val id: Int,
    val title: String,
    val date: String,
    val event_start: String,
    val event_end: String,
    val address: String,
    val description: String,
    val chat_url: String = "tg",
    val image: String = "aaa",
    val city_district: String = "Nefty",
    val category: String,
    val point: Map<String, Any> = mapOf(
        "type" to "Point",
        "coordinates" to listOf(73.36859, 54.99244)
    )
)

data class EventModelResponse(
    val results: List<EventModel>
)

data class Category(
    val id: Int,
    val name: String,
    val slug: String
)