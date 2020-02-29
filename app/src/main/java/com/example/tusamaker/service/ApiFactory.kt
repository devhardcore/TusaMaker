package com.example.tusamaker.service

object ApiFactory {
    val tmApi: TmApi = RetrofitFactory.retrofit("https://api.tusa.rainbowpony.ru/api/v1/")
        .create(TmApi::class.java)
}